fun main(args: Array<String>) {
    var ls = listOf(1, 2, 3, 4)

    val ar1: List<Int> = ArrayList<Int>(ls)
    val ar2: MutableList<Int> = ArrayList<Int>(ls)
    val ar3: ArrayList<Int> = ArrayList<Int>(ls)

    printArrayList1(ar1)
    printArrayList2(ar1)
    printArrayList3(ar1)
    // Type mismatch.
    // Required: MutableList<Int>
    // Found: List<Int>
//    printArrayList4(ar1)
    // Type mismatch.
    // Required: kotlin.collections.ArrayList<Int> /* = java.util.ArrayList<Int> */
    // Found: List<Int>
//    printArrayList5(ar1)

    printArrayList1(ar2)
    printArrayList2(ar2)
    printArrayList3(ar2)
    printArrayList4(ar2)
    // Type mismatch.
    // Required: kotlin.collections.ArrayList<Int> /* = java.util.ArrayList<Int> */
    // Found: List<Int>
//    printArrayList5(ar2)

    printArrayList1(ar3)
    printArrayList2(ar3)
    printArrayList3(ar3)
    printArrayList4(ar3)
    printArrayList5(ar3)
}

fun printArrayList1 (ls: Iterable<Int>) {println(ls)}
fun printArrayList2 (ls: Collection<Int>) {println(ls)}
fun printArrayList3 (ls: List<Int>) {println(ls)}
fun printArrayList4 (ls: MutableList<Int>) {println(ls)}
fun printArrayList5 (ls: ArrayList<Int>) {println(ls)}
