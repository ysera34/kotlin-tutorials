fun main(args: Array<String>) {
    val ar = listOf(1, 2, 3, 4, 5, 6, 7)

    val num = ar.iterator()
    var item: Int

    while (num.hasNext()) {
        item = num.next()
        print("$item")
    }
    println()

    for (item in ar) {
        print("$item")
    }
    println()

    ar.forEach { print("$it") }
    println()


    val list = listOf(1, 2, 3, 4)
    for (i in list) {
        print("${i * 2}")
    }
    println()

    val set = setOf(1, 2, 3, 4, 2)
    for (i in set) {
        print("${i * 2}")
    }
    println()

    // CharRange
    for (i in 'a'..'g') {
        print("$i")
    }
    println()

    // IntRange
    for (i in 1..4) {
        print("$i")
    }
    println()

    val array = arrayOf(1, 2, 3, 4)
    for (i in array) {
        print("${i * 2}")
    }
    println()

    for (i in "This is String") {
        print("${i.toUpperCase()}")
    }
    println()
}
