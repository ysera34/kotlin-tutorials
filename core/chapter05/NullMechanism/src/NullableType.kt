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
}