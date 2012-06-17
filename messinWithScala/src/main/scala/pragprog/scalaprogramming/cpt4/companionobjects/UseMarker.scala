package pragprog.scalaprogramming.cpt4.companionobjects

import pragprog.scalaprogramming.cpt4.companionobjects.Marker

object UseMarker {
    def main(args: Array[String]) {
        println(Marker getMarker "blue")
        println(Marker getMarker "blue")
        println(Marker getMarker "red")
        println(Marker getMarker "red")
        println(Marker primaryColors)
    }
}
