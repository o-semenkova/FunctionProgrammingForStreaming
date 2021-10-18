import MapTask.mapping
import org.scalatest.funsuite.AnyFunSuite

import scala.collection.immutable.Stream

class TestSpecMap extends AnyFunSuite {
  test("Check given function List('1', '2', '3') is mapped correctly") {
    val indexedSeq = for (i <- 0 to 20) yield i
    assert(mapping(indexedSeq.map(_.toString)) == indexedSeq, s"expected to get $indexedSeq")
  }

  test("Check given function List('1', '2', '3', '4,', ',5', '04', '50') is mapped correctly") {
    val seq = List("1", "2", "3", "4,", ",5", "04", "50")
    assert(mapping(seq) == List(1, 2, 3, 4, 50), "expected to get List(1, 2, 3, 4, 50)")
  }

  test("Check given function List() is mapped correctly") {
    val seq = List()
    assert(mapping(seq) == List(), "expected to get List()")
  }

  test("Check given function Stream('1', '2', null).take(2) is mapped correctly") {
    val seq: Stream[String] = "1" #:: ("2" #:: (null #:: Stream()))
    assert(mapping(seq).take(2) == List(1, 2), "expected to get List(1, 2)")
  }
}
