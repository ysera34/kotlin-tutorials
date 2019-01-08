fun main(args: Array<String>) {
    val child = Child("black", "black", "etc")
    child.printHairColor()

    child.changeHairColor("blue")
    child.printHairColor()

    child.changeHairColorSuper("yellow")
    child.printHairColorSuper()
}

open class Parent(open var hairColor: String, open var eyeColor: String) {

    open fun changeHairColor(hairColor: String) {
        this.hairColor = hairColor
    }
}

class Child : Parent {
    override var hairColor: String
    override var eyeColor: String
    var others: String

    constructor(hairColor: String, eyeColor: String, others: String) : super(hairColor, eyeColor) {
        this.hairColor = hairColor
        this.eyeColor = eyeColor
        this.others = others
    }

    override fun changeHairColor(hairColor: String) {
        this.hairColor = hairColor
    }

    fun printHairColor() {
        println("Child hairColor ${this.hairColor}")
    }

    fun changeHairColorSuper(hairColor: String) {
        super.hairColor = hairColor
        super.changeHairColor(hairColor)
    }

    fun printHairColorSuper() {
        println("Parent hairColor ${super.hairColor}")
    }
}
