import java.lang.NumberFormatException

fun main(args: Array<String>) {
    var err: Int? = 100

    try {
        err = parseInt("7A")
    } catch (e: Exception) {
        err = 0
    } catch (e: NumberFormatException) {
        err = null
    }

    println(err)

    err = try {
        parseInt("7A")
    } catch (e: NumberFormatException) {
        null
    } catch (e: Exception) {
        0
    }

    println(err)
}

fun parseInt(value: String): Int {
    return value.toInt()
}
