object FibonacciWithMemoTask {
  def memoFibonacci(): Int => Long = {
    n => {
      if (n < 2) n
      else {
        implicit val store: Array[Long] = new Array[Long](n+1)
        val fib: Int => Long = fix[Int, Long](fib => memoize{
          case n@0 => n
          case n@1 => n
          case n => fib(n-1) + fib(n-2)
        })
        fib(n)
      }
    }
  }

  def fix[T, R](bifnFactory: (T => R) => T => R): T => R = t => bifnFactory(fix(bifnFactory))(t)

  def memoize(fn: Int => Long)(implicit store: Array[Long]): Int => Long = {
    in => {
      val cached = store(in)
      if(cached > 0) {
        cached
      } else {
        val calculated = fn(in)
        store.update(in, calculated)
        calculated
      }
    }
  }
}