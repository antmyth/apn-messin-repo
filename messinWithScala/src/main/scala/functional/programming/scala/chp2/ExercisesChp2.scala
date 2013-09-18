package functional.programming.scala.chp2

object ExercisesChp2 {

  //exercise 3 - currying
  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    (a:A) => f(a,_)

  //exercise 4 - uncurrying
  def curry[A, B, C](f: A => B => C): (A, B) => C =
    (a:A, b:B) => f(a)(b)

  //exercise 5 - compose functions
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))
}
