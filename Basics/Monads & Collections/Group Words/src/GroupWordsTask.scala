object GroupWordsTask {
  def groupIt(wordsSeq: Seq[String]): Map[Char, Int] = {
    wordsSeq.groupBy(_.charAt(0)).transform((key, value) => countOccurences(value, key))
  }
  def countOccurences(words: Seq[String], ch: Char): Int = {
    words.map(c => c.count(x => {x == ch})).sum
  }
}