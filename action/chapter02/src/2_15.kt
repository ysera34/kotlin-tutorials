import Color2.*
import java.lang.Exception

fun mix(c1: Color2, c2: Color2) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty Color")
    }

fun main(args: Array<String>) {
    println(mix(BLUE, YELLOW))
}
