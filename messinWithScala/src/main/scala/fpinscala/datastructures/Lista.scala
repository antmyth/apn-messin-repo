package fpinscala.datastructures


sealed trait Lista[+A]

case object Nil extends Lista[Nothing]

case class Cons[+A](head: A, tail: Lista[A]) extends Lista[A]

object Lista {

  def sum(ints: Lista[Int]): Int =
    foldRight(ints, 0)(_ + _)

  def product(ints: Lista[Int]): Double =
    foldRight(ints, 1.0)(_ * _)

  def foldRight[A, B](l: Lista[A], zero: B)(f: (A, B) => B): B = l match {
    case Nil => zero
    case Cons(x, xs) => f(x, foldRight(xs, zero)(f))
  }

  def tail[A](lista: Lista[A]): Lista[A] = lista match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def drop[A](l: Lista[A], n: Int): Lista[A] = {
    if (n == 0) l
    else l match {
      case Nil => Nil
      case Cons(_, t) => drop(t, n - 1)
    }
  }

  def dropWhile[A](l: Lista[A])(f: A => Boolean): Lista[A] = l match {
    case Nil => Nil
    case Cons(x, xs) =>
      if (f(x))
        dropWhile(xs)(f)
      else
        l
  }

  def init[A](l: Lista[A]): Lista[A] = l match {
    case Nil => Nil
    case Cons(x, Nil) => Nil
    case Cons(x, xs) => Cons(x, init(xs))
  }

  def setHead[A](lista: Lista[A], h: A): Lista[A] = lista match {
    case Nil => Cons(h, Nil)
    case Cons(x, xs) => Cons(h, xs)
  }

  def apply[A](as: A*): Lista[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}



