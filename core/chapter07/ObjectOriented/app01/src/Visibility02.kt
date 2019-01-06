fun main(args: Array<String>) {
    println(accessAll)
    val friend = MyFriend("ally")
    val name = friend.findName("ally")
//    val id = friend.findId("ally") // Error: Cannot access 'findId': it is private in 'MyFriend'
//    printPrivate() // Error: Cannot access 'printPrivate': it is private in file
}
