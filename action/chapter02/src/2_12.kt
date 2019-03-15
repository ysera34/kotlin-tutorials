fun getMnemonic(color2: Color2) =
    when (color2) {
        Color2.RED -> "Richard"
        Color2.ORANGE -> "Of"
        Color2.YELLOW -> "York"
        Color2.GREEN -> "Gave"
        Color2.BLUE -> "Battle"
        Color2.INDIGO -> "In"
        Color2.VIOLET -> "Vain"
    }

fun main(args: Array<String>) {
    println(getMnemonic(Color2.BLUE))
}
