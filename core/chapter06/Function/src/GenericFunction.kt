fun main(args: Array<String>) {
    val list1 = newIntList1(1, 2, 3, 4, 5)
    println(list1)
    val list2 = newStringList1("kotlin", "java", "swift", "javascript")
    println(list2)

    val list3 = newList(1, 2, 3, 4, 5)
    println(list3)
    val list4 = newList("kotlin", "java", "swift", "javascript")
    println(list4)

    // Inspection info: This inspection reports function calls with type arguments that can be safely removed and inferred.
    val list5 = newList<Int>(1, 2, 3, 4, 5)
    println(list5)
}

fun newIntList1(vararg ts: Int): ArrayList<Int> {
    val result = ArrayList<Int>()
    for (t in ts)
        result.add(t)
    return result
}

fun newStringList1(vararg ts: String): ArrayList<String> {
    val result = ArrayList<String>()
    for (t in ts)
        result.add(t)
    return result
}

fun <T> newList(vararg ts: T): ArrayList<T> {
    val result = ArrayList<T>()
    for (t in ts)
        result.add(t)
    return result
}
