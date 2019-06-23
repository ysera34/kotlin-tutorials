enum class Color(val code: String) {
    RED("#F00"),
    BLUE("#00F"),
    GREEN("#0F0");

    companion object {

    }
}

abstract class Color1(val code: String) {
    object Red1 : Color1("#F00")
    object Blue1 : Color1("#00F")
    object Green1 : Color1("#0F0")
}

object Yellow1 : Color1("#FF0")

sealed class Color2(val code: String) {
    object Red2 : Color2("#F00")
    object Blue2 : Color2("#00F")
    object Green2 : Color2("#0F0")
    class CustomColor(code: String) : Color2(code)
}

object Yellow2 : Color2("#FF0")

fun sealedClassTest() {
    val brown = Color2.CustomColor("#cc865c")
}
