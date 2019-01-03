fun main(args: Array<String>) {
    println(8.shr(2))
    println(8 shr 2) // infix function

    val m1 = Score(100, 200)
    val m2 = Score(300, 400)
    println(m1.times(m2))
    println(m1 times m2)
}

data class Score(val a: Int, val b: Int)

// 1. member function or extension function
// 2. only one argument
// 3. infix definition
infix fun Score.times(other: Score): Score {
    return Score(a * other.a, b * other.b)
}
