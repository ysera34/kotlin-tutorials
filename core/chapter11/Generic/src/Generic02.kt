fun <T> newList(vararg ts: T): ArrayList<T> {
    val result = ArrayList<T>()
    for (t in ts)
        result.add(t)
    return result
}

fun main(args: Array<String>) {
    val list1 = newList<Int>(1, 2, 3, 4, 5)
    println(list1)
    val list2 = newList(1, 2, 3, 4, 5)
    println(list2)
}
