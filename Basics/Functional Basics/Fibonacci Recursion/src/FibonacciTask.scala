object FibonacciTask {

	def fibonacciImpl(): Int => Int = {
      def fibNumNumber: Int => Int = number => {
				if (number < 2) {
					number
				} else fibNumNumber(number - 1) + fibNumNumber(number - 2)
			}
		fibNumNumber
	}
}