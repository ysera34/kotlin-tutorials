var propertyCount = 100
    get() {
        println("get accessor of propertyCount")
        return field
    }
    set(value) {
        println("set accessor of propertyCount")
        field = value
    }

fun main(args: Array<String>) {
    println("propertyCount: $propertyCount")

    var fieldCount = 100
    println("fieldCount: $fieldCount")
    fieldCount += 200

    property1 += property2
    println(property1)

    val friend1 = MyFriend2("john", "000", 5) // The getter setter was not called when generating the instance.
    println("${friend1.name}, ${friend1.tel}, ${friend1.type}")
    friend1.type = 2
    println("${friend1.name}, ${friend1.tel}, ${friend1.type}")
}

var property1 = 100
    get() {
        println("get accessor of property1")
        return field
    }
    set(value) {
        println("set accessor of property1")
        field = value
    }
val property2 = 200
    get() {
        println("get accessor of property2")
        return field
    }

class MyFriend1(var name: String, val tel: String, var type: Int) {
    init {
        this.type = if (type < 4) type else 4
    }
}

class MyFriend2(name: String, tel: String, type: Int) {
    var name: String = name
        get() {
            println("get accessor of name")
            return field
        }
        set(value) {
            println("set accessor of name")
            field = value
        }
    var tel: String = tel
        get() {
            println("get accessor of tel")
            return field
        }
        set(value) {
            println("set accessor of tel")
            field = value
        }
    var type: Int = type
        get() {
            println("get accessor of type")
            return field
        }
        set(value) {
            println("set accessor of type")
            field = if (value < 4) value else 4
        }
}
