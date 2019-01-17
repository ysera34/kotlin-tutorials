fun calculateTotal1(from: Int, to: Int): Int {
    var total: Int = 0

    val lambda = there@ { from: Int, to: Int ->
        for (i in from..to) {
            total += i
        }
        return@there
    }

    lambda(from, to)
    return total
}

fun main(args: Array<String>) {
    println("1..100 total=${calculateTotal1(1, 100)}")

    val numbers = Array(5){ i -> (i * i) }
    println(numbers.filter { it % 2 == 0 })

    val list = listOf(1, 2, 3, 4, 5)
    println(list.map { it + 10 })

    val friends = listOf(FriendMine("jack", 30, "000"),
            FriendMine("ally", 31, "111"))
    println(friends.filter { it.age >= 30 }.map(FriendMine::name))
    println(friends.filter { it.age >= 30 }.map { FriendMine::name })

    fun FriendMine.isOld() = age >= 30
    println(friends.filter {(FriendMine::isOld)(it)}.map(FriendMine::name))
    val checkAge = FriendMine::isOld
    println(friends.filter {checkAge(it)}.map(FriendMine::name))

    val createFriend = ::FriendMine
    println(createFriend("john", 32, "222"))

    fun hello() = println("Hello")
    run(::hello)
    run({hello()})
}
