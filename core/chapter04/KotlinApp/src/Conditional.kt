fun main(args: Array<String>) {
    var x = 100
    if (x == 100)
        println("x = $x")
    if (x == 100) {
        ++x
        println("x = $x")
    }

    if (x == 100)
        println("x is 100")
    else
        println("x is not 100")

    if (x < 50)
        println("x is less than 50.")
    else if ((x >= 50) and (x < 70))
        println("x is 50 ~ 70")
    else if ((x >= 70) and (x < 90))
        println("x is 70 ~ 89")
    else
        println("x is greater than 90.")


    // Statement
    val y1 = 100
    var msg1: String

    if (y1 == 100)
        msg1 = "y is 100"
    else
        msg1 = "y is not 100"
    println(msg1)

    // Expression
    val y2 = 100
    var msg2 = if (y2 == 100) "y is 100" else "y is not 100"
    println(msg2)

    // Direct delivery
    val y3 = 100
    println( if(y3 == 100) "y is 100" else "y is not 100" )


    // when expression
    whenUsage(2, 50, "seoul")
}

fun whenUsage(inputType: Int, score: Int, city: String) {
    when (inputType) {
        1 -> println("inputType 1")
        2, 3 -> println("inputType 2 or 3")
        else -> {
            println("else")
        }
    }

    when (inputType) {
        checkInputType(inputType) -> {
            println("type normal")
        }
        else -> print("type not normal")
    }

    val start = 0
    val end = 100
    when (score) {
        in start..(end / 4) -> println("excellent")
        50 -> println("average")
        in start..end -> println("In Range")
        else -> println("Not In Range")
    }

    val isSeoul = when (city) {
        is String -> city.startsWith("seoul")
        else -> false
    }
    println(isSeoul)

    when {
        city.length == 0 -> println("Please enter a city name.")
        city.substring(0, 5).equals("seoul") -> println("city is seoul")
        else -> println(city)
    }
}

fun checkInputType(inputType: Int) : Int {
    if (inputType >= 1 && inputType < 3) {
        return inputType
    }
    return -1
}
