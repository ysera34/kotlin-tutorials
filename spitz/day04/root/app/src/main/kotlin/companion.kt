class Parent1 {
    companion object {
        fun action() {

        }
    }
}

abstract class Parent2
class Parent3 {
    val Child1 = object : Parent2() {}
}
object Child1 : Parent2()

class SingleTon1 {
    companion object {
        val INSTANCE = SingleTon1()
    }
}

class SingleTon2 {
    companion object {
        val INSTANCE by lazy { SingleTon2() }
    }
}

class Child2 : Parent2() {
    companion object {
        val INSTANCE by lazy { Child2() }
    }
}
