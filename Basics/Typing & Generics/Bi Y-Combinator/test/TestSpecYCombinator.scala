import BiYCombinator.fix
import org.scalatest.funsuite.AnyFunSuite

class TestSpecYCombinator extends AnyFunSuite {

	test("Factorial Test") {
		val factorial = fix[Long, Int, Long](
          factorial => (state, n) =>
            if (n == 0) state
            else factorial(state * n, n - 1)
        ).curried(1)

		val expectedResult1 = 2 * 3 * 4 * 5
		assert(factorial(5) == expectedResult1,
		       s"Expected Factorial(5) is " + s"$expectedResult1")

		val expectedResult2 = 2 * 3 * 4 * 5 * 6 * 7
		assert(factorial(7) == expectedResult2,
		       s"Expected Factorial(7) is $expectedResult2")
	}
}
