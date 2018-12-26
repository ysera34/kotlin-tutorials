fun main(args: Array<String>) {
    val x = B()
    println(x is A)
    println(x is B)
}

open class A {}

class B : A() {}
