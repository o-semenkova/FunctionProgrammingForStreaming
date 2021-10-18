import TakeWordsTask.takeWords
import org.scalatest.funsuite.AnyFunSuite

class TestSpecTake extends AnyFunSuite {

  test("List(\"Hello\", \"world!\", \"\\n\", \"Test\", \"asda\") should be transformed into List(\"Hello\", \"world!\")") {
    assert(takeWords(List("Hello", "world!", "\n", "Test", "asda")) == List("Hello", "world!"), "Expected results matching")
  }

  test("List(\"Hello\", \"world!\n\", \"Test\", \"asda\") should be transformed into List(\"Hello\", \"world!\")") {
    assert(takeWords(List("Hello", "world!\n", "Test", "asda")) == List("Hello", "world!"), "Expected results matching")
  }

  test("List(\"Hello\", \"world!\nTest\", \"asda\") should be transformed into List(\"Hello\", \"world!\")") {
    assert(takeWords(List("Hello", "world!\nTest", "asda")) == List("Hello", "world!"), "Expected results matching")
  }

  test("List(\"Hello\", \"world!\nTest\nTest\", \"asda\") should be transformed into List(\"Hello\", \"world!\")") {
    assert(takeWords(List("Hello", "world!\nTest", "asda")) == List("Hello", "world!"), "Expected results matching")
  }

  test("List() should be transformed into List()") {
    assert(takeWords(List()) == List(), "Expected results matching")
  }

  test("List('\n') should be transformed into List()") {
    assert(takeWords(List("\n")) == List(), "Expected results matching")
  }
}
