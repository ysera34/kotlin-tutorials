class UserException3 : Throwable() {
}

class UserException4 : Throwable() {
}

fun firstEx() {
    throw UserException3()
}

fun secondEx() {
    throw UserException4()
}

fun main(args: Array<String>) {
    try {
        firstEx()
    } finally {
        secondEx()
    }
}
