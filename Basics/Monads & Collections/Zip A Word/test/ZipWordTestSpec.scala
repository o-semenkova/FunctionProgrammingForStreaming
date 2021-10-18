import ZipWordTask.zipIt
import org.scalatest.funsuite.AnyFunSuite

class ZipWordTestSpec extends AnyFunSuite {
  test("Check List(\"over\", \"extra\") List(\"size\", \"large\") List(\"d\", \"\") transformed to List(\"oversized\", \"extralarge\")") {
    assert(zipIt(List("over", "extra"), List("size", "large"), List("d", "")) == List("oversized", "extralarge"), "Expect matching")
  }
}
