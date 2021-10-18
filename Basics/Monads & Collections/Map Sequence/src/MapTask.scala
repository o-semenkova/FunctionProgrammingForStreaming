object MapTask {
  def mapping(input: Seq[String]): Seq[Int] = {
    val out: Seq[Int] = input.filter(x => isAllDigits(x)).map(_.toInt)
    out
  }
  def isAllDigits(x: String) = x forall Character.isDigit
}
