class UserException : Throwable()

fun throwEx() {
    println("A UserException exception was thrown in the throwEx() function.")
    throw UserException()
}

fun main(args: Array<String>) {
    try {
        throwEx()
    } catch (e: UserException) {
        println("Exception handled.")
    }
}