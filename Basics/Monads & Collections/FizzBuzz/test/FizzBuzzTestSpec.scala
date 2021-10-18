import FizzBuzzTask.fizzBuzzIt
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class FizzBuzzTestSpec extends AnyFunSuite {
  //TODO: implement your test here
  test("Check FizzBuzz") {
    (0 until 100).foreach { _ =>
      val rndStart = Random.nextInt(Int.MaxValue - 100)
      val range = rndStart until (rndStart + 100)

      range.zip(fizzBuzzIt(range))
        .foreach { t =>
          (t._1 % 3, t._1 % 5) match {
            case (0, 0) => assert(t._2 == "FizzBuzz", s"Expect that Value(${t._1}) multiple of 3 and 5 to be FizzBuzz but was ${t._2}")
            case (0, _) => assert(t._2 == "Fizz", s"Expect that Value(${t._1}) multiple of 3 to be Fizz but was ${t._2}")
            case (_, 0) => assert(t._2 == "Buzz", s"Expect that Value(${t._1}) multiple 5 to be Buzz but was ${t._2}")
            case (_, _) => assert(t._2 == t._1.toString, s"Expect that Value(${t._1}) neither multiple of 3 nor 5 to be ${t._1} but was ${t._2}")
          }
        }
    }
  }
}
