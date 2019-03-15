fun main(args: Array<String>) {
    val person = Person2("Bob", true)
    println(person.name)
    println(person.isMarried)

    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}
