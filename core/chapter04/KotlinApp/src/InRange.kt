import java.time.LocalDate

fun main(args: Array<String>) {

    // in convention
    val num = arrayOf(100, 200, 300, 400)
    println("${200 in num}")
    println("${num.contains(200)}")
    println("${200 !in num}")
    println("${!num.contains(200)}")

    // range operator
    val lowerAlpha = 'a'..'z' // CharRange
    val numberRange = 1..100 // IntRange
    val isLower = 'd' in lowerAlpha
    val isNumber = 101 in numberRange

    // for
    for (i in 1..7) print(i)
    for (i in 'a'..'g') print(i)
    println()

    // date range
    val start = LocalDate.now()
    val end = start..start.plusDays(15)
    println(start.plusWeeks(1) in end)
    println(end)
}
