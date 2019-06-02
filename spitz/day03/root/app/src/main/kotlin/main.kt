fun main() {
    println("hello world in app")
    hello()

    studyNullability()
}

fun studyNullability() {
    val double: (Int) -> Int = { it * 2 }
    val v0: Int = 3
    println("${double(v0)}")

    val v1: Int? = null
    if (v1 != null) println("${double(v1)}") // Smart cast to kotlin.Int
}
