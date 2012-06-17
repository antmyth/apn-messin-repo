package pragprog.scalaprogramming.cpt5.SensibleTyping

import java.util._

class Generics2 {
    var list1 = new ArrayList[Int]
    var list2 = new ArrayList[Any]

    var ref1: Int = 1
    var ref2: Any = null

    ref2 = ref1

    list2 = list1
}
