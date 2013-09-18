package functional.programming.scala.chp2

import org.specs2.mutable._
import functional.programming.scala.chp2.ExercisesChp2._

class ExercisesChp2Test extends Specification {

  "The curry function" should {
    "return " in {
      def f(x: Int, y: String): String = x + y

      curry(f)(1)("-+-") must be equalTo (1 + "-+-")
    }
  }
  "The compose function" should {
    "return " in {
      def f(x: Int): String = x + ""
      def g(s: String): String = s + "--";

      compose(g, f)(1) must be equalTo "1--"
    }
  }

}
