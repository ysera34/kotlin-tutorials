fun main(args: Array<String>) {
    val v1 = calculate(2, 7) { a, b -> a * b }
    val v2 = calculate(3, 100) { a, b -> a + b }
    val v3 = calculate(50, 200) { a, b -> a - b }

    println("v1 result: $v1")
    println("v2 result: $v2")
    println("v3 result: $v3")
}

fun calculate(value1: Int, value2: Int,
        executeCode: (codeParam1: Int, codeParam2: Int) -> Int): Int {
    return executeCode(value1, value2)
}
