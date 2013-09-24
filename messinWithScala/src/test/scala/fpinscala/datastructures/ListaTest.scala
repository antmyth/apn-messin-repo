package fpinscala.datastructures

import org.specs2.mutable.Specification

class ListaTest extends Specification {
  "The Lista " should {
    "match " in {
      val x = Lista(1, 2, 3, 4, 5) match {
        case Cons(x, Cons(2, Cons(4, _))) => x
        case Nil => 42
        case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
        case Cons(h, t) => h + Lista.sum(t)
        case _ => 101
      }
      x must be equalTo (3)
    }

    "remove first element" in {
      Lista.tail(Lista(1, 2, 4)) must be equalTo Lista(2, 4)
    }

    "remove n elements" in {
      Lista.drop(Nil, 2) must be equalTo Nil
      Lista.drop(Lista(1, 2, 4), 1) must be equalTo Lista(2, 4)
      Lista.drop(Lista(1, 2, 4), 2) must be equalTo Lista(4)
      Lista.drop(Lista(1, 2, 4), 3) must be equalTo Nil
      Lista.drop(Lista(1, 2, 4), 20) must be equalTo Nil
    }
    "remove elements while" in {
      def f(x: Int):Boolean = x <= 2
      val lista: Lista[Int] = Lista(1, 2, 4)

      Lista.dropWhile(Nil)( f) must be equalTo Nil
      Lista.dropWhile(lista)( f) must be equalTo Lista(4)
      Lista.dropWhile(Lista(1, 3, 4))( f) must be equalTo Lista(3, 4)
      Lista.dropWhile(Lista(1,2))( f) must be equalTo Nil
    }

    "swap first element" in {
      Lista.setHead(Lista(1, 2, 4), 9) must be equalTo Lista(9, 2, 4)
      Lista.setHead(Nil, 9) must be equalTo Lista(9)
    }

    "remove the last element " in {
      Lista.init(Lista(1, 2, 4)) must be equalTo Lista(1, 2)
      Lista.init(Nil) must be equalTo Nil
    }
  }

}
