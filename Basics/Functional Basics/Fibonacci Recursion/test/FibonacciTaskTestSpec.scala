import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class FibonacciTaskTestSpec extends AnyFunSuite {

  test("Check Impl Correctness for depth 0") {
    assert(FibonacciTask.fibonacciImpl()(0) == 0, "fib(0) should be equal to 0")
  }

  test("Check Impl Correctness for depth 1") {
    assert(FibonacciTask.fibonacciImpl()(1) == 1, "fib(1) should be equal to 1")
  }

  test("Check Impl Correctness for depth 2") {
    assert(FibonacciTask.fibonacciImpl()(2) == 1, "fib(2) should be equal to 1")
  }

  test("Check Impl Correctness for depth 5") {
    assert(FibonacciTask.fibonacciImpl()(5) == 5, "fib(5) should be equal to 5")
  }

  test("Check Impl Correctness for Random Value") {
    val random = new Random()
    val depth = (random nextInt 10) + 1

    assertFibImpl(FibonacciTask.fibonacciImpl(), depth)
  }

  def assertFibImpl(fibImpl: Int => Int, depth: Int) {
    assert(
      fibImpl(depth - 1) + fibImpl(depth) == fibImpl(depth + 1),
      s"""fib($depth-1) plus fib($depth) should be equal to fub($depth + 1)""")
  }
}
