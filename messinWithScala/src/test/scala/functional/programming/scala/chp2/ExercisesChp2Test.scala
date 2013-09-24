package functional.programming.scala.chp2

import org.specs2.mutable._
import functional.programming.scala.chp2.ExercisesChp2._

class ExercisesChp2Test extends Specification {

  "The fib function" should {
    "calculate the correct number " in {
      fib(1) must be equalTo 0
      fib(3) must be equalTo 1
      fib(6) must be equalTo 5
    }
  }
  "The isSorted function" should {
    "return  true " in {
      isSorted(Array(1, 2, 2), (a: Int, b: Int) => a >= b) must be equalTo true
      isSorted(Array(1, 2, 3), (a: Int, b: Int) => a > b) must be equalTo true
    }
    "return  false " in {
      isSorted(Array(1, 2, 2), (a: Int, b: Int) => a > b) must be equalTo false
      isSorted(Array(3, 2, 1), (a: Int, b: Int) => a > b) must be equalTo false
    }
  }
  "The curry function" should {
    "return a composite " in {
      def f(x: Int, y: String): String = x + y

      curry(f)(1)("-+-") must be equalTo (1 + "-+-")
    }
  }
  "The compose function" should {
    "return a composite " in {
      def f(x: Int): String = x + ""
      def g(s: String): String = s + "--";

      compose(g, f)(1) must be equalTo "1--"
    }
  }

}
