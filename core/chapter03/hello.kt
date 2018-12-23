fun main(args: Array<String>) {
    printHello(1)
}

fun printHello(msgType: Int) {
    when (msgType) {
        1, 2 -> println("Hello")
        else -> println("message number error")
    }
}