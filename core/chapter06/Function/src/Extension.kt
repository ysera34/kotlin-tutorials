fun main(args: Array<String>) {
    val mList = mutableListOf(1, 2, 3)
    mList.swap(0, 2)
    println(mList)
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}
