import javax.management.StringValueExp

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

class Friend7 {

    var name: String
    var tel: String
    var type: Int

    constructor(name: String) : this(name, " ", 4) {
        println("constructor1: $name")
        println("constructor1: $tel")
        println("constructor1: $type")
    }

    constructor(name: String = "peter", tel: String = " ") : this(name) {
        println("constructor2: $name")
        println("constructor2: $tel")
        println("constructor2: $type")
    }

    constructor(name: String, tel: String, type: Int = 4) {
        this.name = name
        this.tel= tel
        this.type = if (type < 4) type else 4
        println("constructor3: $name")
        println("constructor3: $tel")
        println("constructor3: $type")
    }
}

fun main(args: Array<String>) {
    val friend1 = Friend6("john", "000-0000-0000")
    println(friend1.type)
    val friend2 = Friend6("john", "000-0000-0000", 3)
    println(friend2.type)
    val friend3 = Friend6(name = "john", type = 5, tel = "000-0000-0000")
    println(friend3.type)

    val friend4 = Friend7(name = "john")
    println(friend4.name)
    /**
     * result
     * constructor3: john
     * constructor3:
     * constructor3: 4
     * constructor1: john
     * constructor1:
     * constructor1: 4
     * john
     */
    
    val friend5 = Friend7()
    println(friend5.name)
    /**
     * result
     * constructor3: peter
     * constructor3:
     * constructor3: 4
     * constructor1: peter
     * constructor1:
     * constructor1: 4
     * constructor2: peter
     * constructor2:
     * constructor2: 4
     * peter
     */
}
