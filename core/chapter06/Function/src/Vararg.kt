fun main(args: Array<String>) {
    val e = intArrayOf(7, 8, 9)
    val list = newIntList(1, 2, 3, *e, 5) // *: spread operator
    println(list) // [1, 2, 3, 7, 8, 9, 5]

    println(list.get(2))
    list.set(0, 100)
    println(list)

    list.add(10)
    println(list)

    list.remove(2)
    println(list)
}

fun newIntList(vararg ts: Int): ArrayList<Int> {
    val result = ArrayList<Int>()
    for (t in ts) {
        result.add(t)
    }
    return result
}
