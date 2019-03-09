fun <T: Number> sumValue(vararg ts: T): Double { // upper bound
    var result = 0.0
    for (t in ts)
        result += t.toDouble()
    return result
}

fun <T: Comparable<T>> min(first: T, second: T): T {
    return if (first < second) first else second

//    val result = first.compareTo(second)
//    return if (result < 0) first else second
}

fun main(args: Array<String>) {
    println("sum: ${sumValue(1, 2, 7)}")
    // Type parameter bound for T in
    // fun <T: Number> sumValue(vararg ts: T): Double
    // is not satisfied: inferred type String is not a subtype of Number
//    println("sum: ${sumValue("1", "2", "7")}")

    println("min(): ${min(2, 5)}")
    println("min(): ${min("james", "peter")}")
}
