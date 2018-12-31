fun main(args: Array<String>) {

    min1(100, 50)

    // default value
    min3(100)
    min3()

    // named argument
    min2(valueLeft = 50, valueRight = 100)
    min2(valueRight = 100, valueLeft = 50)

    // default value, named argument
    min3(valueLeft = 50)
}

fun min1(valueLeft: Int, valueRight: Int): Int {
    return if (valueLeft < valueRight) valueLeft else valueRight
}

fun min2(valueLeft: Int, valueRight: Int) = if (valueLeft < valueRight) valueLeft else valueRight

// default value parameter
fun min3(valueLeft: Int = 0, valueRight: Int = 0) = if (valueLeft < valueRight) valueLeft else valueRight