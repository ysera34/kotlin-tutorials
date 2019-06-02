fun main() {
    println("hello world in app")
    hello()

    studyNullability()
    studyBeforeInline()
    studyAfterInline()
    tryInlineFun()
    tryExtensionFun()
    studyScope()
    printElement(parseHTML("""
        <div>
            test1
            <img />
            test2
            <p a="3" b="abc">pTest</p>
        </div>
    """.trimIndent()))
}

fun studyNullability() {
    val double: (Int) -> Int = { it * 2 }
    val v0: Int = 3
    println("${double(v0)}")

    val v1: Int? = null
    if (v1 != null) println("${double(v1)}") // Smart cast to kotlin.Int
}
