fun main(args: Array<String>) {
    val s1: String? = null
//    val s2: String = null // Error: Null can not be a value of a non-null type String
//    val s3: String = s1 // Error: Type mismatch. Required:String, Found:String?
    val s4: String = "abc"
    val s5: String? = s4

    var s6: String = "Let's learn Kotlin."
    println(s6.length)
//    s6 = null // Error: Null can not be a value of a non-null type String

    var s7: String? = "Let's learn Kotlin."
//    println(s7.length) // Error: Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    if (s7 != null) println(s7.length) // Smart cast to kotlin.String

    s7 = null
    println(s7?.length)
    s7 = "Let's learn Kotlin."
    println(s7?.length) // Unnecessary safe call on a non-null receiver of type String?
    println(s7.length)

    if (s7 != null) { // Condition 's7 != null' is always 'true'
        val s8: String? = s7.substring(5) // Smart cast to kotlin.String
        if (s8 != null) {
            println(s8.length) // Smart cast to kotlin.String
        }
    }
    println(s7?.substring(5)?.length) // Unnecessary safe call on a non-null receiver of type String?

    // Elvis operator
    var s8: String? = "Let's learn Kotlin."
    val s9 = s8?.length ?: 0 // val b: Int = if (s8 != null) a.length else 0
}
