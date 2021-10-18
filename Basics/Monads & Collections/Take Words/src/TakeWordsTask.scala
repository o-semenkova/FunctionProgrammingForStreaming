import scala.annotation.tailrec

object TakeWordsTask {
  val lineSeparatorString = "\n"

//  def takeWords(seq: Seq[String]): Seq[String] = {
//    val result: Seq[String] = seq.take(seq.indexWhere(_.contains(lineSeparatorString)))
//    result
//  }
def takeWords(seq: Seq[String]): Seq[String] = seq
  .flatMap(decoupleLineSeparator(Nil, _))
  .takeWhile(w => !w.contains(lineSeparatorString))


  @tailrec def decoupleLineSeparator(list: List[String], word: String): List[String] = word match {
    case "\n" => list :+ lineSeparatorString
    case x if x.contains(lineSeparatorString) =>
      val tuple = x.splitAt(x.indexOf(lineSeparatorString))
      decoupleLineSeparator(list :+ tuple._1 :+ lineSeparatorString, tuple._2.slice(1, tuple._2.length))
    case x => list :+ x
  }
}
