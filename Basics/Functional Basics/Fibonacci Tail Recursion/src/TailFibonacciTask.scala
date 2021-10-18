import scala.annotation.tailrec

object TailFibonacciTask {
  def fibonacciImpl2(): Int => Int = {
    @tailrec def fibHelper(current: Int, previous: Int, step: Int): Int = {
      if (step == 0) current
      else fibHelper(current + previous, current, step - 1)
    }
    def fun: Int => Int = depth => {
      if (depth < 2) depth
      else fibHelper(1, 0, depth - 1)
    }
    fun
  }
}