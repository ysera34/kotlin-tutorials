fun main(args: Array<String>) {
    val ls1 = listOf("1", "2", "3", "4")
    println("ls1 initial elements: $ls1")

    println(JavaCollection.addOne(ls1))
    println("ls1 updated elements: $ls1")

    val ls2 = listOf("1", "2", "3", "4")
    println("ls2 initial elements: $ls2")

    println(addOne(ls2 as MutableList<String>))
    println("ls2 updated elements: $ls2")
}

fun addOne(ls: MutableList<String>): MutableList<String> {
    for (index in ls.indices) {
        ls.set(index, (ls.get(index).toInt() + 1).toString())
    }
    return ls
}
