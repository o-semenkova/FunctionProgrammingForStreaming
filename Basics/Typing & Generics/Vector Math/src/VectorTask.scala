import scala.annotation.tailrec

object VectorTask {

	trait Vector[T <: Vector[T]] {

		/**
		 * Get value of the vector at specific position
		 *
		 * @param position of vector value. Must be less than `size`
		 * @return value at the given position */
		def apply(position: Int): Float

		/**
		 * Create a new Vector instance with the given value and previous values
		 *
		 * @param position of vector value. Must be less than `size`
		 * @param value    the value to set
		 * @return new instance of this vector */
		def modify(position: Int, value: Float): T

		/**
		 * Provides the size of this vector
		 *
		 * @return actual size of the vector */
		def size(): Int
	}

	def sum[T <: Vector[T]](vector1: T, vector2: T): T = {
		recursiveHelper((a, b) => a + b, vector1, vector2, vector2, vector1.size() - 1)
	}

	def sub[T <: Vector[T]](vector1: T, vector2: T): T = {
		recursiveHelper((a, b) => a - b, vector1, vector2, vector2, vector1.size() - 1)
	}

	@scala.annotation.tailrec def recursiveHelper[T <: Vector[T]](op: (Float, Float) => Float,
																																vector1: T,
																																vector2: T,
																																state: T,
																																n: Int): T = {
		if (n < 0) state else recursiveHelper(op,
			vector1,
			vector2,
			state.modify(n, op(vector1(n), vector2(n))),
			n - 1)
	}

	

}