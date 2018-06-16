package org.inframincer.hellokotlin

/**
 * Created by yoon on 2018. 6. 13..
 */
/**
 *
class Person(name: String, age: Int) {

}
 */

/**
 * default constructor : no parameter
 *
class Person() {
    constructor(name: String, age: Int) : this()
}
 */

/**
 * constructor : parameter
 *
class Person(name: String) {
    constructor(name: String, age: Int) : this(name)
}
 */

/**
 * default value constructor
 *
class Person(name: String = "No Name", age: Int = 0) {

}
 */

/**
 * init function
 *
class Person(var name: String?, var age: Int = 0) {
    init {
        if (name.isNullOrBlank()) name = "No Name"
    }
}
 */

/**
 * visibility modifiers
 *
open class Person {
    private val a = 1
    protected val b = 2
    internal val c = 3
    val d = 4
}
 */

class Person() {
    var name: String = ""
        get() = "Name : " + field

    var age: Int = 0
    set(age) { field = +1 }

    var privateAge: Int = 0
    private set
}

