import FlattingTask.flattingStrings
import org.scalatest.funsuite.AnyFunSuite

class TestSpecFlatting extends AnyFunSuite {
  test("Should flatten words into chars") {
    assert(
      flattingStrings(List("abc", "def", "ghj", "klm", "nop"))
        ==
        List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p'),
      "Expected flatting into List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p')")
  }
}
