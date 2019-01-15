val seven = { 7 } // () -> Int
val printer = { str: String -> println(str) } // (String) -> Unit
val sum = { a: Int, b: Int -> a + b } // (Int, Int) -> Int

fun main(args: Array<String>) {
    // run: The Kotlin standard library function that executes a lambda expression without arguments.
    println(run(seven))
    // () Means an invoke function call of an anonymous class instance that executes a lambda expression.
    println(seven())

    val v1 = 100
    val v2: () -> Int = { v1 + 7 }
    println("v2 => $v2")
    println("v2() => ${v2()}")
    
    val v3 = { v1 + 7 }
    println("v3 => $v3")
    println("v3() => ${v3()}")

    println({v1 + 7}())
}
