fun getWarmth1(color2: Color2) = when (color2) {
    Color2.RED, Color2.ORANGE, Color2.YELLOW -> "warm"
    Color2.GREEN -> "neutral"
    Color2.BLUE, Color2.INDIGO, Color2.VIOLET -> "cold"
}

fun main(args: Array<String>) {
    getWarmth1(Color2.ORANGE)
}
