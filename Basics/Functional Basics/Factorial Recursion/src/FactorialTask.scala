object FactorialTask {

  def factorialImpl(): Int => Int = {
    // Simple recursion
    def factorial: Int => Int = number => {
//      if (number == 0) {
//        1
//      } else number * factorial(number - 1)
      if (number <= 1) 1
      else number * factorial(number - 1)
    }
    factorial
  }
}