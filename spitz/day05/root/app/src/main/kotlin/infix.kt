fun infixTest() {
    val list = ListA() + "abc"
    println("list: ${list.list}")
    list add "def"
    println("list: ${list.list}")

    val list1 = 10 combine 20
    println("list1: $list1")
    val list2 = 10 combine 20 combine 30
    println("list2: $list2")
    val list3 = 10 combine 20 combine 30 combine 40
    println("list3: $list3")
    val list4 = 10 combine 20 combine 30 combine 40 combine mutableListOf(50, 60)
    println("list4: $list4")

    val map1 = mapOf("a" to 1, "b" to 2)
    println("map1: $map1")
    val map2 = mapOf("a" to ("b" to 2))
    println("map2: $map2")
}

class ListA {
    val list = mutableListOf<String>()
    operator fun get(i: Int) = list[i]
    operator fun plus(string: String) = run {
        list += string
        this
    }
    infix fun add(string: String) = plus(string)
}

infix fun <T> T.combine(v: T) = mutableListOf(this, v)
infix fun <T> MutableList<T>.combine(v: T) = run {
    this.add(v)
    this
}
infix fun <T> MutableList<T>.combine(v: MutableList<T>) = run {
    this += v
    this
}
infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
