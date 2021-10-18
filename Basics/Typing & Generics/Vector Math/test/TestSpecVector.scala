import org.scalatest.funsuite.AnyFunSuite

import scala.tools.nsc.Settings
import scala.tools.nsc.interpreter.{IMain, IR}


case class Vector2(x: Float, y: Float) extends VectorTask.Vector[Vector2] {

  override def apply(position: Int): Float = position match {
    case 0 => x
    case 1 => y
    case _ => throw new IndexOutOfBoundsException
  }

  override def modify(position: Int, value: Float): Vector2 = position match {
    case 0 => Vector2(value, y)
    case 1 => Vector2(x, value)
    case _ => throw new IndexOutOfBoundsException
  }

  override def size(): Int = 2
}

case class Vector3(x: Float, y: Float, z: Float) extends VectorTask.Vector[Vector3] {

  override def apply(position: Int): Float = position match {
    case 0 => x
    case 1 => y
    case 2 => z
    case _ => throw new IndexOutOfBoundsException
  }

  override def modify(position: Int, value: Float): Vector3 = position match {
    case 0 => Vector3(value, y, z)
    case 1 => Vector3(x, value, z)
    case 2 => Vector3(x, y, value)
    case _ => throw new IndexOutOfBoundsException
  }

  override def size(): Int = 3
}

class TestSpecVector extends AnyFunSuite {

  val settings = new Settings
  settings.usejavacp.value = true
  settings.deprecation.value = true

  test("Expected sum of vectors to compile and pass") {
    val code =
      s"""
         |val x = Vector2(1, 2)
         |val y = Vector2(2, 1)
         |VectorTask.sum(x, y)
         |""".stripMargin

    val eval = new IMain(settings)
    val evaluated = eval.interpret(code)

    assert(evaluated == IR.Success, s"Expected to be successfully compiled and evaluated but was $evaluated")

    val res = eval.valueOfTerm("res0").get.asInstanceOf[VectorTask.Vector[_]]
    assert(res == Vector2(3, 3), s"Expected that sum of vectors (1, 2) and (2, 1) is (3, 3) but was $res")
  }

  test("Expected subtract of vectors to compile and pass") {
    val code =
      s"""
         |val x = Vector2(1, 2)
         |val y = Vector2(2, 1)
         |VectorTask.sub(x, y)
         |""".stripMargin

    val eval = new IMain(settings)
    val evaluated = eval.interpret(code)

    assert(evaluated == IR.Success, s"Expected to be successfully compiled and evaluated but was $evaluated")

    val res = eval.valueOfTerm("res0").get.asInstanceOf[VectorTask.Vector[_]]
    assert(res == Vector2(-1, 1), s"Expected that subtract of vectors (1, 2) and (2, 1) is (-1, 1) but was $res")
  }

  test("Expected sum of vectors of different size to fail at the compilation time") {
    val code =
      s"""
         |val x = Vector2(1, 2)
         |val y = Vector3(2, 1, 0)
         |VectorTask.sum(x, y)
         |""".stripMargin

    val eval = new IMain(settings)
    val evaluated = eval.interpret(code)

    assert(evaluated == IR.Error, s"Expected to fail on compiling type-safe sum of vectors")
  }

  test("Expected subtract of vectors of different size to fail at the compilation time") {
    val code =
      s"""
         |val x = Vector2(1, 2)
         |val y = Vector3(2, 1, 0)
         |VectorTask.sub(x, y)
         |""".stripMargin

    val eval = new IMain(settings)
    val evaluated = eval.interpret(code)

    assert(evaluated == IR.Error, s"Expected to fail on compiling type-safe sum of vectors")
  }
}
