
object FizzBuzzTask {
  def fizzBuzzIt(s: Seq[Int]): Seq[String] = {
    s.map(fizzBuzz)
  }
  def fizzBuzz(x:Int) = {
    if (x % 15 == 0)
      "FizzBuzz"
    else if (x % 3 == 0)
      "Fizz"
    else if (x % 5 == 0)
      "Buzz"
    else
      x.toString
  }
}