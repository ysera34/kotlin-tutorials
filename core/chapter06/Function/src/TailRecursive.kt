fun main(args: Array<String>) {
    println(calcFactorial0(5))
    println(calcFactorial1(5.0))
    println(calcFactorial2(5.0))
    println(calcFactorial(5.0))
}

fun calcFactorial0(num: Int): Double {
    var total: Double = 1.0
    for (i in num downTo 1) {
        total *= i
    }
    return total
}

fun calcFactorial1(num: Double): Double {
    if (num == 1.0) {
        return 1.0
    } else {
        return (num * calcFactorial1(num - 1))
    }
}

fun calcFactorial2(num: Double): Double = if (num == 1.0) 1.0 else num * calcFactorial2(num - 1)

tailrec fun calcFactorial(num: Double, total: Double = 1.0): Double =
        if (num == 1.0) total else calcFactorial(num - 1, total * num)
