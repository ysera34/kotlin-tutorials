import java.lang.StringBuilder

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    val list1 = listOf(1, 2, 3)
    println(list1.joinToString(separator = "; ", prefix = "(", postfix = ")"))

    val list2 = arrayListOf(1, 2, 3)
    println(list2.joinToString(" "))
}
