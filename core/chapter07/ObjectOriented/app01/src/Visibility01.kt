public val accessAll: String = "can be used anywhere"

internal class MyFriend(var name: String) {
    fun findName(name: String): String {
        TODO()
    }
    private fun findId(name: String): String {
        TODO()
    }
}

private fun printPrivate() {
    println("Private")
}

fun main(args: Array<String>) {
    println(accessAll)
    val friend = MyFriend("jack")
    val name = friend.findName("jack")
//    val id = friend.findId("jack") // Error: Cannot access 'findId': it is private in 'MyFriend'
    printPrivate()
}
