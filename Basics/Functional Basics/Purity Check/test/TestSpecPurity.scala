import PurityTask.{Integer, isPure}
import org.scalatest.funsuite.AnyFunSuite

class TestSpecPurity extends AnyFunSuite {

	test("Ensures state modifying function is detected") {
		assert(!isPure(i => {
			i.value += 1
			i
		}), "Expected given function is not pure")
	}

	test("Ensures changing state relying function is detected") {
		var cache: Integer = null;
		assert(!isPure(i => {
			val next = Integer(i.value + 1)

			if (cache == null) {
				cache = next
			}

			cache
		}), "Expected given function is not pure")
	}

	test("Ensures pure function is detected") {
		assert(isPure(i => Integer(i.value + 1)), "Expected given function is not pure")
	}
}
