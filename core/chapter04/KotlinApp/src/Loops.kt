fun main(args: Array<String>) {
    val items1 = listOf("apple", "banana", "kiwi")
    for (item in items1) {
        println(item)
    }

    val items2 = listOf("apple", "banana", "kiwi")
    for (index in items2.indices) {
        println("item at $index is ${items2[index]}")
    }

    val items3 = arrayOf("apple", "banana", "kiwi")
    for (index in items3.indices) {
        println("item at $index is ${items3[index]}")
    }

    // for in expression sample
    /*
    for (i in 1..100) { ... } // 1 ~ 100
    for (i in 0 until 100) { ... } // 0 ~ 99
    for (i in 2..10 step 2) { ... } // 2 ~ 10 step 2
    for (i in 10 downTo 1) { ... } // 10 ~ 1
    for (i in 10 downTo 1 step 2) { ... } // 10 ~ 1 step 2
    */
}
