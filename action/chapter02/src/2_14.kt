import Color2.*

fun getWarmth2(color2: Color2) = when (color2) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}

fun main(args: Array<String>) {
    getWarmth2(ORANGE)
}
