package pragprog.scalaprogramming.cpt4.companionobjects

class Marker(val color: String) {
    println("Creating " + this)

    override def toString = "Marker color:" + color
}

object Marker {
    private val markers = Map(
        "red" -> new Marker("Red"),
        "green" -> new Marker("Green"),
        "blue" -> new Marker("Blue")
    )

    def primaryColors = "red, green, blue"

    def getMarker(color: String) = {
        if (markers.contains(color)) markers(color) else null
    }
}