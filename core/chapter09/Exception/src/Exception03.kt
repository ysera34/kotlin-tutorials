class UserException2 : Throwable {
    constructor() {}
    constructor(message: String) : super(message) {}
}

fun throwEx2() {
    println("A UserException2 exception was thrown in the throwEx2() function.")
    throw UserException2()
}

fun throwEx3() {
    println("A UserException2 exception was thrown in the throwEx3() function.")
    throw UserException2("This exception is a user exception.")
}

fun main(args: Array<String>) {
    try {
        throwEx2()
    } catch (e: UserException2) {
        e.printStackTrace()
    }

    try {
        throwEx3()
    } catch (e: UserException2) {
        e.printStackTrace()
    }
}
