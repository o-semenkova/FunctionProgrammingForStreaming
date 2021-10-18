object PrimeCheckerTask {

	def isPrime(n: Long): Boolean = {
		def check(n: Long, currDivisor: Int): Boolean = {
			if (n < 2) false
			else if (n % 2 == 0) n == 2
			else if (currDivisor * currDivisor > n) true
			else if (n % currDivisor == 0) false
			else check(n, currDivisor + 2)
	}
		check (n, 3)
	}
}