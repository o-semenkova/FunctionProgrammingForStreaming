
object PurityTask {

  case class Integer(var value: Int) { }

  def isPure(incrementFn: Integer => Integer): Boolean = {
    val v1 = Integer(1) // 2
    val v2 = incrementFn(v1) // 3
    def checkSideEffect(incrementFn: Integer => Integer): Boolean = {
      val v3 = incrementFn(v1) // 3
      (v1.value + 1) == v2.value && (v1.value + 1) == v3.value
    }
    def checkNonAssignment(incrementFn: Integer => Integer): Boolean = {
      val v3 = incrementFn(v2) // 4
      (v1.value + 1) == v2.value && (v2.value + 1) == v3.value
    }
    if (checkNonAssignment(incrementFn) && checkSideEffect(incrementFn)) true
    else false
  }
}