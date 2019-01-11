fun main(args: Array<String>) {
    val result1 = Outer.Nested().nestedFun()
    println(result1)

    val result2 = Outer().Inner().innerFun()
    println(result2)

    val result3 = Outer().Inner().useSuper()
}

open class SuperOuter {
    val superBar: Int = 0
    fun superFun() = -1
}

class Outer : SuperOuter() {
    private val bar: Int = 1

    class Nested {
        fun nestedFun() = 2
//        fun nestedFun() = bar // Error: Unresolved reference: bar
    }

    inner class Inner {
        fun innerFun() = bar
        fun useSuper() {
            println(superBar)
            println(superFun())
        }
    }
}
