//open class Parent(var hairColor: String, var eyeColor: String)

//class Child(var hairColor: String, var eyeColor: String): Parent(hairColor, eyeColor)
// Error: 'hairColor' hides member of supertype 'Parent' and needs 'override' modifier
// 'hairColor' in 'Parent' is final and cannot be overridden

open class Parent1(open var hairColor: String, open var eyeColor: String)

class Child1(override var hairColor: String, override var eyeColor: String): Parent1(hairColor, eyeColor)

class Child11(hairColor: String, eyeColor: String) : Parent1(hairColor, eyeColor)

class Child12 : Parent1 {
    override var hairColor
        get() = super.hairColor
        set(value) { field = value }

    override var eyeColor: String

    constructor(hairColor: String, eyeColor: String) : super(hairColor, eyeColor) {
        this.hairColor = hairColor
        this.eyeColor = eyeColor
    }
}

open class Parent2(var hairColorP: String, var eyeColorP: String)

class Child2(var hairColorC: String, var eyeColorC: String): Parent2(hairColorC, eyeColorC)

open class Parent3(var hairColor: String, var eyeColor: String)

class Child3 : Parent3 {
    constructor(hairColor: String, eyeColor: String) : super(hairColor, eyeColor) {
        this.hairColor = hairColor
        this.eyeColor = eyeColor
    }
}

// If the property of child is different from the property of parent, the property of parent is also created.
fun main(args: Array<String>) {
    val child2 = Child2("black", "black")
    println("Child2 ${child2.hairColorP}, ${child2.eyeColorP}")
    println("Child2 ${child2.hairColorC}, ${child2.eyeColorC}")

    child2.hairColorP = "gray"
    child2.eyeColorP = "blue"
    println("Child2 ${child2.hairColorP}, ${child2.eyeColorP}")
    println("Child2 ${child2.hairColorC}, ${child2.eyeColorC}")

    val child11 = Child11("yellow", "blue")
    println("Child11 ${child11.hairColor}, ${child11.eyeColor}")
    val child12 = Child12("yellow", "blue")
    println("Child12 ${child12.hairColor}, ${child12.eyeColor}")
    child12.hairColor = "blue"
    println("Child12 ${child12.hairColor}, ${child12.eyeColor}")
    val child3 = Child3("yellow", "blue")
    println("child3 ${child3.hairColor}, ${child3.eyeColor}")
    child3.hairColor = "blue"
    println("child3 ${child3.hairColor}, ${child3.eyeColor}")
}
