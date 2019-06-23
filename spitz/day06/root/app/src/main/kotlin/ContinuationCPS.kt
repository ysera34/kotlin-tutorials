fun continuationCPSTest() {
    println(factorial(3))
    println(factorial(4))
    println(factorial(5))
    factorialCPS(3, ::println)
    try {
        println(factorialThrow(-3))
    } catch (e: Throwable) {
        println(e)
    }
    factorialCPSException(-3, ::println, ::println)
}

fun factorial(n: Int) = tailrecFactorial(n, 1)

tailrec fun tailrecFactorial(n: Int, a: Int): Int = if (n == 0) {
    a
} else {
    println("n $n; a $a" )
    tailrecFactorial(n - 1, n * a)
}

fun factorialCPS(n: Int, block: (Int) -> Unit) = tailrecFactorialCPS(n, 1, block)

tailrec fun tailrecFactorialCPS(n: Int, a: Int, block: (Int) -> Unit) {
    if (n == 0) {
        block(a)
    } else {
        tailrecFactorialCPS(n - 1, n * a, block)
    }
}

fun factorialThrow(n: Int) = tailrecFactorialThrow(n, 1)

fun tailrecFactorialThrow(n: Int, a: Int): Int = when {
    n < 0 -> throw Throwable("invalid value: $n")
    n == 0 -> a
    else -> tailrecFactorialThrow(n -1, n * a)
}

fun factorialCPSException(n: Int, block: (Int) -> Unit, exception: (String) -> Unit = {}) =
        tailrecFactorialCPSException(n, 1, block, exception)

tailrec fun tailrecFactorialCPSException(n: Int, a: Int, block: (Int) -> Unit, exception: (String) -> Unit) {
    when {
        n < 0 -> exception("invalid value: $n")
        n == 0 -> block(a)
        else -> tailrecFactorialCPSException(n - 1, n * a, block, exception)
    }
}
