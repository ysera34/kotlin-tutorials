@JvmName("printListInt")
fun printList(ls: List<Int>) {
    ls.forEach { print("$it") }
}

fun printList(ls: List<String>) {
    ls.forEach { print("$it") }
}

fun main(args: Array<String>) {
    printList(listOf(1, 2))
    printList(listOf("james", "peter"))

    val list = listOf(1, 2)
    // Cannot check for instance of erased type: List<String>
//    if (list is List<String>) {println("List<String> type")}
}