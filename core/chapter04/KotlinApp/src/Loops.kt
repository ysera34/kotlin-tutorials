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

    // while
    val items4 = listOf("apple", "banana", "kiwi")
    var index4 = 0
    while (index4 < items4.size) {
        println("item at $index4 is ${items4[index4]}")
        index4++
    }

    // do-while
    val items5 = listOf("apple", "banana", "kiwi")
    var index5 = 0
    do {
        println("item at $index5 is ${items5[index5]}")
        index5++
    } while (index5 < items5.size)
}
