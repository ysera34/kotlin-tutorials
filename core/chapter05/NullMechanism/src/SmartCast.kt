fun main(args: Array<String>) {
    var a: String? = "Let's learn Kotlin."
    if (a != null) {
        println(a.length) // Smart cast to kotlin.String
    }

    // is !is
    smartCast("smart cast")
}

fun smartCast(t: Any) {
    if (t is String)
        println("t = ${t.length}") // Smart cast to kotlin.String

    if (t !is String)
        return
    else
        println("t = ${t.length}") // Smart cast to kotlin.String

    // || On the right side of the operator,
    // Smart cast to kotlin.String
    if (t !is String || t.length == 0) return

    // && On the right side of the operator,
    // Smart cast to kotlin.String
    if (t is String && t.length > 0)
        println("t = ${t.length}") // Smart cast to kotlin.String

    when (t) {
        is Int -> println(t + 1) // Smart cast to kotlin.Int
        is String -> println(t.length + 1) // Smart cast to kotlin.String
        is IntArray -> println(t.sum()) // Smart cast to kotlin.IntArray
    }
}
