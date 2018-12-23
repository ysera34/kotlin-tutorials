fun main(args: Array<String>) {
    println(makeMessage1(1))
    println(makeMessage1(2))
    println(makeMessage2(1))
    println(makeMessage2(2))
}

fun makeMessage1(msgType: Int) : String {
    return if (msgType == 1) "Hello" else "I met you again."
}

fun makeMessage2(msgType: Int) = if (msgType == 1) "Is the weather good?" else "It's very clear."