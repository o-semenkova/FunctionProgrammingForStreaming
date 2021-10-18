import ImageFilteringTask.filterImage
import org.scalatest.funsuite.AnyFunSuite

import java.util

class ImageProcessingTestSpec extends AnyFunSuite {

  val filter: Array[Array[Int]] => Array[Array[Int]] = filterImage(source => (row, coll) => {
    if (row - 1 < 0 || coll - 1 < 0 || row + 1 >= source.length || coll + 1 >= source(0).length) {
      0
    } else {
      (for (i <- row - 1 to row + 1) yield (for (j <- coll - 1 to coll + 1) yield source(i)(j)).sum).sum / 9
    }
  }, 3)

  test("Should process correctly case 9x9") {
    val result: Array[Array[Int]] = filter(Array(
      Array(10, 1, 1, 1, 1, 10, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 10),
      Array(1, 1, 1, 10, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(10, 1, 1, 1, 1, 1, 10, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 10, 1, 1, 10, 1, 1, 10),
    ))

    val expected: Array[Array[Int]] = Array(
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 2, 1, 1, 2, 2, 2, 2, 0),
      Array(0, 1, 2, 2, 2, 1, 1, 2, 0),
      Array(0, 1, 2, 2, 2, 1, 1, 2, 0),
      Array(0, 2, 2, 2, 2, 2, 2, 2, 0),
      Array(0, 2, 1, 1, 1, 2, 2, 2, 0),
      Array(0, 2, 1, 1, 1, 2, 2, 2, 0),
      Array(0, 2, 2, 2, 2, 2, 2, 2, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0),
    )
    assert(util.Arrays.deepEquals(result.asInstanceOf[Array[AnyRef]], expected.asInstanceOf[Array[AnyRef]]), "Should process correctly")
  }

  test("Should process correctly case 7x9") {
    val result: Array[Array[Int]] = filter(Array(
      Array(10, 1, 1, 1, 1, 10, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 10),
      Array(1, 1, 1, 10, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(10, 1, 1, 1, 1, 1, 10, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
    ))

    val expected: Array[Array[Int]] = Array(
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 2, 1, 1, 2, 2, 2, 2, 0),
      Array(0, 1, 2, 2, 2, 1, 1, 2, 0),
      Array(0, 1, 2, 2, 2, 1, 1, 2, 0),
      Array(0, 2, 2, 2, 2, 2, 2, 2, 0),
      Array(0, 2, 1, 1, 1, 2, 2, 2, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0),
    )
    assert(util.Arrays.deepEquals(result.asInstanceOf[Array[AnyRef]], expected.asInstanceOf[Array[AnyRef]]), "Should process correctly")
  }

  test("Should process correctly case 9x7") {
    val result: Array[Array[Int]] = filter(Array(
      Array(10, 1, 1, 1, 1, 10, 1),
      Array(1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 10, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1),
      Array(10, 1, 1, 1, 1, 1, 10),
      Array(1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 10, 1, 1, 10, 1),
    ))

    val expected: Array[Array[Int]] = Array(
      Array(0, 0, 0, 0, 0, 0, 0),
      Array(0, 2, 1, 1, 2, 2, 0),
      Array(0, 1, 2, 2, 2, 1, 0),
      Array(0, 1, 2, 2, 2, 1, 0),
      Array(0, 2, 2, 2, 2, 2, 0),
      Array(0, 2, 1, 1, 1, 2, 0),
      Array(0, 2, 1, 1, 1, 2, 0),
      Array(0, 2, 2, 2, 2, 2, 0),
      Array(0, 0, 0, 0, 0, 0, 0),
    )
    assert(util.Arrays.deepEquals(result.asInstanceOf[Array[AnyRef]], expected.asInstanceOf[Array[AnyRef]]), "Should process correctly")
  }
}
