import PrimeCheckerTask.isPrime
import org.scalatest.funsuite.AnyFunSuite

import scala.math.pow

class TestSpecPrime extends AnyFunSuite {

  test("ensures 3 is prime") {
    assert(isPrime(3), "Expected 3 to be prime")
  }

  test("ensures 7 is prime") {
    assert(isPrime(7), "Expected 3 to be prime")
  }

  test("ensures 11 is prime") {
    assert(isPrime(11), "Expected 11 to be prime")
  }

  test("ensures 773 is prime") {
    assert(isPrime(773), "Expected 11 to be prime")
  }

  test("ensures 507961 is prime") {
    assert(isPrime(507961), "expected 507961 to be prime number")
  }

  test("ensures 15 is not prime") {
    assert(!isPrime(15), "expected 15 not to be prime number")
  }

  test("ensures 507962 is prime") {
    assert(!isPrime(507962), "expected 507962 not to be prime number")
  }

  test("ensures any pow of 2 is not prime") {
    for (i <- 2 to 64 by 2) {
      val value = pow(2, i).longValue()
      assert(!isPrime(value), s"expected $value not to be prime number")
    }
  }
}
