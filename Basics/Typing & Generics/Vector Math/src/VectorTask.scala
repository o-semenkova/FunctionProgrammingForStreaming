object VectorTask {

	trait Vector/* GENERIC */ {

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
		def modify(position: Int, value: Float): Vector

		/**
		 * Provides the size of this vector
		 *
		 * @return actual size of the vector */
		def size(): Int
	}

	def sum/* GENERIC */(vector1: Vector, vector2: Vector): Vector = ???

	def sub/* GENERIC */(vector1: Vector, vector2: Vector): Vector = ???

	

}