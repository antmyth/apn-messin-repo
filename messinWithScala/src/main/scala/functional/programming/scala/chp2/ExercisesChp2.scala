package functional.programming.scala.chp2

object ExercisesChp2 {

  //exercise 1 - fibonacci sequence
  def fib(n: Int): Int = {
    if (n == 1) 0;
    else if (n == 2) 1
    else fib(n - 1) + fib(n - 2)

  }

  def findFirst[A](ds: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= ds.length) -1
      else if (p(ds(n))) n
      else loop(n + 1)

    loop(0)
  }

  //exercise 2  - isSorted
  def isSorted[A](ds: Array[A], gt: (A, A) => Boolean): Boolean = {
    def loop(n: Int): Boolean =
      if ((n + 2) == ds.length) gt(ds(n + 1), ds(n))
      else if (!gt(ds(n + 1), ds(n))) false
      else loop(n + 1);

    loop(0)
  }

  //exercise 3 - currying
  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    (a: A) => f(a, _)

  //exercise 4 - uncurrying
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  //exercise 5 - compose functions
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))
}
