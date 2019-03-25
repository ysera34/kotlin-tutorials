import java.lang.StringBuilder

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun main(args: Array<String>) {
    println("Kotlin".lastChar)

    val stringBuilder = StringBuilder("Kotlin?")
    stringBuilder.lastChar = '!'
    println(stringBuilder)
}
