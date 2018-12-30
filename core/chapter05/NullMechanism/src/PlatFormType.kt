fun main(args: Array<String>) {
    printJavaClass(PlatformTypeTestClass("Platform Type Test"))

    // Exception in thread "main" java.lang.IllegalStateException:
    // javaClass.getPlatFormVariable() must not be null
    printJavaClass(PlatformTypeTestClass(null))
}

fun printJavaClass(javaClass: PlatformTypeTestClass) {
//    println(javaClass.platFormVariable.toLowerCase())
    println((javaClass.platFormVariable ?: "Null!!").toLowerCase())
}
