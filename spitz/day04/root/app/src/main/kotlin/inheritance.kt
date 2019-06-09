fun inheritanceTest() {
    println("class test01")
    ClassTest01("a", "b").run {
        println("constructor1")
        println("propA: $propA, propB: $propB")
    }
    ClassTest01("a").run {
        println("constructor2")
        println("propA: $propA, propB: $propB")
    }

    println("class test02")
    ClassTest02().run {
        println("propA: $propA, propB: $propB, propC: $propC")
    }

    println("class test03")
    ClassTest03().run {
        println("propA: $propA, propB: $propB, propC: $propC")
    }

    println("class test04")
    ClassTest04("a", "b", "c").run {
        println("propA: $propA, propB: $propB, propC: $propC")
    }

    println("class test05")
    ClassTest05("a", "b", "c").run {
        println("propA: $propA, propB: $propB, propC: $propC")
    }
}

open class ClassTest01(open val propA: String, open val propB: String) {
    constructor(a: String) : this(a, "b")
}

class ClassTest02 : ClassTest01("a") {
    val propC = "c"
}

class ClassTest03 : ClassTest01("a", "b") {
    val propC = "c"
}

class ClassTest04(override val propA: String, override val propB: String, val propC: String) : ClassTest01("a")

class ClassTest05(override val propA: String, override val propB: String, val propC: String) : ClassTest01("a", "b")
