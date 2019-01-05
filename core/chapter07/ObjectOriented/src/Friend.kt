class Friend {
}

class Friend1(var name: String, var tel: String)

class Friend2 constructor(var name: String, var tel: String)

class Friend3(cName: String, cTel: String) {
    var name = cName
    var tel = cTel
}

class Friend4(name: String, tel: String) {
    var name: String
    var tel: String

    // initialization block
    init {
        this.name = name
        this.tel = tel
    }
}

class Friend5(var name: String, var tel: String, var type: Int) {
    init {
        this.type = if (type < 4) type else 4
    }
}

class Friend6(var name: String, var tel: String, var type: Int = 4) {
    init {
        this.type = if (type < 4) type else 4
    }
}

fun main(args: Array<String>) {
    val friend1 = Friend6("john", "000-0000-0000")
    println(friend1.type)
    val friend2 = Friend6("john", "000-0000-0000", 3)
    println(friend2.type)
    val friend3 = Friend6(name = "john", type = 5, tel = "000-0000-0000")
    println(friend3.type)
}
