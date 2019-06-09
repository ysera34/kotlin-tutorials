fun classTest() {
    println("class test1")
    ClassTest1("a", "b")
    ClassTest1("a")

    println("class test2")
    ClassTest2("a", "b")
    ClassTest2("a")

    println("class test3")
    ClassTest3("a", "b")
    ClassTest3("a")

    println("class test4")
    ClassTest4("a", "b").run {
        println("constructor1")
        println("propA: $propA, propB: $propB")
    }
    ClassTest4("a").run {
        println("constructor2")
        println("propA: $propA, propB: $propB")
    }
}

class ClassTest1 {
    private val propA: String
    private val propB: String

    constructor(a: String, b: String) {
        println("constructor1")
        propA = a
        propB = b
        println("propA: $propA, propB: $propB")
    }

    constructor(a: String) : this(a, "b") {
        println("constructor2")
        println("propA: $propA, propB: $propB")
    }
}

class ClassTest2 constructor(a: String, b: String) {
    private val propA: String
    private val propB: String

    init {
        println("constructor1")
        propA = a
        propB = b
        println("propA: $propA, propB: $propB")
    }

    constructor(a: String) : this(a, "b") {
        println("constructor2")
        println("propA: $propA, propB: $propB")
    }
}

class ClassTest3(private val propA: String, private val propB: String) {
    init {
        println("constructor1")
        println("propA: $propA, propB: $propB")
    }

    constructor(a: String) : this(a, "b") {
        println("constructor2")
        println("propA: $propA, propB: $propB")
    }
}

class ClassTest4(val propA: String, val propB: String) {
    constructor(a: String) : this(a, "b")
}
