fun main(args: Array<String>) {

    val friends = listOf(FriendMine("jack", 30, "000"),
            FriendMine("ally", 31, "111"))
    println(friends.filter { it.age >= 30 })
    println(friends.filter(fun (friend) = friend.age >= 30))
    println(
        friends.filter(
            fun (friend): Boolean {
                return friend.age >= 30
            }
        )
    )

    val value: Int = 100
    val list = listOf(1, 2, 3, 4, 5)

    println(list.map { it + value })
    println(list.map(fun (it): Int { return it + value }))
}
