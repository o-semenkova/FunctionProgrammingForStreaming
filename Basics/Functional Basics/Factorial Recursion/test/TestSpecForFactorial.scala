import FactorialTask.factorialImpl
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class TestSpecForFactorial extends AnyFunSuite {

	test("Checks that Factorial(0) is 1") {
		val factorial = factorialImpl()
		val res = factorial(0)
		assert(res == 1, s"Expected factorial(0) is 1 but was $res")
	}

	test("Checks that Factorial(1) is 1") {
		val factorial = factorialImpl()
		val res = factorial(1)
		assert(res == 1, s"Expected factorial(1) is 1 but was $res")
	}

	test("Checks that Factorial(5) is 120") {
		val factorial = factorialImpl()
		val res = factorial(5)
		assert(res == 120, s"Expected factorial(5) is 120 but was $res")
	}

	test("Checks that rnd is Factorial(rnd) / Factorial(rnd - 1)") {
		val factorial = factorialImpl()
		val rnd = Random.nextInt(25) + 1
		val resrnd = factorial(rnd)
		val resprevrnd = factorial(rnd - 1)
		val resf = resrnd / resprevrnd

		assert(rnd == resf,s"Expected factorial($rnd) / factorial(${rnd - 1}) is $rnd" +
			s"but got $resrnd / $resprevrnd is $resf")
	}
}
