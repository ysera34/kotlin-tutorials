import Color2.*
import java.lang.Exception

fun mixOptimized(c1: Color2, c2: Color2) =
    when {
        (c1 == RED && c2 == YELLOW) ||
        (c1 == YELLOW && c2 == RED) ->
            ORANGE
        (c1 == YELLOW && c2 == BLUE) ||
        (c1 == BLUE && c2 == YELLOW) ->
            GREEN
        (c1 == BLUE && c2 == VIOLET) ||
        (c1 == VIOLET && c2 == BLUE) ->
            INDIGO
        else -> throw Exception("Dirty Color")
    }

fun main(args: Array<String>) {
    println(mixOptimized(BLUE, YELLOW))
}
