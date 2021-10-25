object BiYCombinator {

	def fix[X1, X2, R](bifnFactory: ((X1, X2) => R) => (X1, X2) => R): (X1, X2) => R =
		(x1, x2) => bifnFactory(fix(bifnFactory)) (x1, x2)
}