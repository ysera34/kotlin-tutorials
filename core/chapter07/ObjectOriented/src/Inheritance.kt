//open class Parent(var hairColor: String, var eyeColor: String)

//class Child(var hairColor: String, var eyeColor: String): Parent(hairColor, eyeColor)
// Error: 'hairColor' hides member of supertype 'Parent' and needs 'override' modifier
// 'hairColor' in 'Parent' is final and cannot be overridden

open class Parent1(open var hairColor: String, open var eyeColor: String)

class Child1(override var hairColor: String, override var eyeColor: String): Parent1(hairColor, eyeColor)

open class Parent2(var hairColorP: String, var eyeColorP: String)

class Child2(var hairColorC: String, var eyeColorC: String): Parent2(hairColorC, eyeColorC)

// If the property of child is different from the property of parent, the property of parent is also created.
fun main(args: Array<String>) {
    val child2 = Child2("black", "black")
    println("Child2 ${child2.hairColorP}, ${child2.eyeColorP}")
    println("Child2 ${child2.hairColorC}, ${child2.eyeColorC}")

    child2.hairColorP = "gray"
    child2.eyeColorP = "blue"
    println("Child2 ${child2.hairColorP}, ${child2.eyeColorP}")
    println("Child2 ${child2.hairColorC}, ${child2.eyeColorC}")
}
