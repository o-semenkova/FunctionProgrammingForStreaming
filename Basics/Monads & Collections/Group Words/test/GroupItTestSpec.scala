import GroupWordsTask.groupIt
import org.scalatest.funsuite.AnyFunSuite

class GroupItTestSpec extends AnyFunSuite {
  test("Check") {
    assert(groupIt(Seq("ABCA", "BCD", "ABC", "DASD", "KASD", "MWF", "ARPCAAA")) == Map('A' -> 7, 'B' -> 1, 'D' -> 2, 'K' -> 1, 'M' -> 1), "Expected matching")
  }
}
