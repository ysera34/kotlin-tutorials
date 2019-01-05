fun main(args: Array<String>) {
    val f1 = MyFriend()
    println("${f1.name} ${f1.tel} ${f1.type} ${f1.nameLength}")

    f1.name = "johnjohn"
    f1.tel = "000"
    f1.type = 2
    println("${f1.name} ${f1.tel} ${f1.type} ${f1.nameLength}")
}

class MyFriend {
    var name: String = "??"
        get() {
            println("called get accessor of name")
            return if (field != "??") field else "NONE"
        }
        set(value) {
            println("called set accessor of name")
            field = value
        }

    var tel: String = "??"
        get() {
            println("called get accessor of tel")
            return if (field != "??") field else "NONE"
        }
        set(value) {
            println("called set accessor of tel")
            field = value
        }

    var type: Int = 4
        get() {
            println("called get accessor of type")
//            return type // Exception in thread "main" java.lang.StackOverflowError
            return field // have to use a backing field
        }
        set(value) {
            println("called set accessor of type")
            field = if (value < 4) value else 4
        }

    val nameLength: Int
        get() = name.length // Do not create a backing field.
//    val nameLength: Int = name.length
}
