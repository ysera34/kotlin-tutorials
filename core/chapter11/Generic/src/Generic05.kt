interface Transportation
class Car: Transportation
class Airplane: Transportation

inline fun <reified T> checkType(s: Any) {
    if (s is T) {
        println("same type")
    } else {
        println("another type")
    }
}

fun main(args: Array<String>) {
    checkType<Car>(Car())
    checkType<Airplane>(Car())
    checkType<Transportation>(Car())
}
