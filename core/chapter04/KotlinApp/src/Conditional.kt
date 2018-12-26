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
}
