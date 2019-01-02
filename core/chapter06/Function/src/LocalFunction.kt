fun main(args: Array<String>) {
    println(calcCombination(45, 6))
}

fun calcCombination(whole: Int, selected: Int): Double {
    fun calcFactorial(num: Int): Double {
        var total: Double = 1.0
        for (i in num downTo 1) {
            total *= i
        }
        return total
    }

    if ((selected > whole) || selected <= 0 || whole <= 0) {
        return -1.0
    } else if (selected == whole) {
        return 1.0
    }

    return calcFactorial(whole) /
            (calcFactorial(whole - selected) * calcFactorial(selected))
}
