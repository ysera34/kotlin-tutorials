import java.lang.IllegalArgumentException

fun eval2(e: Expr): Int =
    when (e) {
        is Num ->
            e.value
        is Sum ->
            eval2(e.right) + eval2(e.left)
        else ->
            throw IllegalArgumentException("Unknown expression")
    }

fun main(args: Array<String>) {
    println(eval2(Sum(Num(1), Num(2))))
}
