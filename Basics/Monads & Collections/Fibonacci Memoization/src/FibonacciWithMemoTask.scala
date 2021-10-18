object FibonacciWithMemoTask {
  def memoFibonacci(): Int => Long = {
    def fib(n: Int): Long = {
      if (n == 0) 0
      else if (n == 1) 1
      else fib(n - 1) + fib(n - 2)
    }

    fib
  }
}