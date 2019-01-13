fun main(args: Array<String>) {
    println(sum1(10, 20))

    println(sum2_1(10, 20))
    println(sum2_2(10, 20))

    println(sum3_1(10, 20))
    println(sum3_2(10, 20))
    println(sum3_3(10, 20))
    println(sum3_4(10, 20))

    println(sum4_1(10, 20))
    println(sum4_2(10, 20))

    println(sum5(10, 20))

    println(sum6(10, 20))

    println(sum7_1(10, 20))
    println(sum7_2(10, 20))
}

fun sum1(a: Int, b: Int): Int {
    return a + b
}

fun sum2_1(a: Int, b: Int): Int = a + b
fun sum2_2(a: Int, b: Int) = a + b

// anonymous fun #1 Specify function type
val sum3_1: (Int, Int) -> Int = fun(a: Int, b: Int): Int { return a + b }
val sum3_2: (Int, Int) -> Int = fun(a: Int, b: Int) =  a + b
val sum3_3: (Int, Int) -> Int = fun(a, b): Int { return a + b }
val sum3_4: (Int, Int) -> Int = fun(a, b) = a + b

// anonymous fun #2 Omit function type
val sum4_1 = fun(a: Int, b: Int): Int { return a + b }
val sum4_2 = fun(a: Int, b: Int) = a + b

// lambda #1 Specify function type
val sum5: (Int, Int) -> Int = {a, b -> a + b} // => lambda sum3

// lambda #2 Omit function type
val sum6 = {a: Int, b: Int -> a + b} // => lambda sum4

// If you write multiple expressions in a lambda expression on one line, you must put a semicolon in the middle.
// When there are multiple expressions in a lambda expression, the result of the last expression is the return value.
val sum7_1 = {a: Int, b: Int -> println(a + b); a + b}
val sum7_2 = {a: Int, b: Int -> a + b; println(a + b)}
