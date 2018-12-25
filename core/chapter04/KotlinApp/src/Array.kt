fun main(args: Array<String>) {
    val item = arrayOf("apple", "banana", "kiwi")
    for (fruit in item) {
        println(fruit)
    }
    item.forEach { println(it) }

    val num1 = Array<String>(5, { i -> (i * i).toString() })
    val num2 = Array<String>(5) { i -> (i * i) .toString() }
    val num3 = Array(5, { i -> (i * i).toString() })
    val num4 = Array(5) { i -> (i * i) .toString() }

    // primitive type array
    val intItems1: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val intItems2 = IntArray(5, { i -> i })
    val intItems3 = IntArray(5) { i -> i }
}
