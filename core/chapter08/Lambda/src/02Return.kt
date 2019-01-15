val lambda1 = { a: Int, b: Int ->
    println(a + b)
    a + b
}
val lambda2 = { a: Int, b: Int -> println(a + b); a + b }

data class FriendMine(val name: String, val age: Int, val tel: String)

val friends = listOf(FriendMine("jack", 31, "000"),
        FriendMine("ally", 32, "111"),
        FriendMine("peter", 33, "222"),
        FriendMine("john", 34, "333"),
        FriendMine("tom", 35, "444"))

fun findFriend1(friendList: List<FriendMine>, char: Char) {
    for (friend in friendList) {
        if (friend.name.substring(0, 1) == char.toString())
            println("find $char")
            return
    }
    println("end to find $char")
}

fun findFriend2(friendList: List<FriendMine>, char: Char) {
    friendList.forEach {
        if (it.name.substring(0, 1) == char.toString()) {
            println("find $char")
            return
        }
    }
    println("end to find $char")
}

fun findFriend3(friendList: List<FriendMine>, char: Char) {
    friendList.forEach here@ {
        if (it.name.substring(0, 1) == char.toString()) {
            println("find $char")
            return@here
        }
    }
    println("end to find $char")
}

fun main(args: Array<String>) {
    println(lambda1)
    println(lambda1(1, 2))
    println(lambda2)
    println(lambda2(1, 2))

    findFriend1(friendList = friends, char = 'j')
    findFriend2(friendList = friends, char = 'j')
    findFriend3(friendList = friends, char = 'j')
}
