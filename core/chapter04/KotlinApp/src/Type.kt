fun main(args: Array<String>) {
    var a = 100
//    a = 123.45 // Error: The floating-point literal does not conform to the expected type Int

    val b: Int = 100 // Explicitly given type is redundant here
//    val c: Long = a // Error: Type mismatch. Required:Long, Found:Int
    val c: Long = b.toLong()
    val d: Long = b + 1L

    stringType()
    primitiveTypeLiteral()
    stringTypeLiteral()
}

fun typeConversion() {
    val a: Byte = 7
    val b: Short = a.toShort()
    val c: Int = a.toInt()
    val d: Long = a.toLong()
    val e: Float = a.toFloat()
    val f: Double = a.toDouble()
    val g: Char = a.toChar()
}

fun stringType() {
    var s: String = "The value before the change"
    println(s)
    s = "The value after the change"
    println(s)
}

fun stringTypeConversion() {
    val a1: Int = 27
//    val a2: String = a1 // Type mismatch. Required:String, Found:Int
    val a2: String = a1.toString()

    val s1 = "7"
    val s2 = "7.12"
    val s3 = "true"

    val b1 = s1.toByte()
    val b2 = s1.toShort()
    val b3 = s1.toInt()
    val b4 = s1.toLong()
    val b5 = s2.toFloat()
    val b6 = s2.toDouble()
    val b7 = s3.toBoolean()
}

fun primitiveTypeLiteral() {
    val bin1 = 0B00000011 + 1
    println(bin1)
    val bin2 = 0b10000000 + 1
    println(bin2)

    val x: Byte = 2
    val y = x + 1L
}

fun stringTypeLiteral() {
    val s1 = "Hercle, boreas ferox!.\nEquisos cadunt in teres aetheres!\n"

    val s2 = """
        Nobilis lanista superbe visums ausus est.
        Sunt nutrixes talem festus, velox mineralises.
    """.trimIndent()
    println(s2)

    val s3 = """
        >Nobilis lanista superbe visums ausus est.
        >Sunt nutrixes talem festus, velox mineralises.
    """.trimMargin(">")
    println(s3)


    val c = "77".toInt()
    val d = "123.5".toDouble()
    println("$c, $d")


    val count = 77
    val e1 = "count = $count"
    val e2 = "Length of $e1 is ${e1.length}"
    println(e1)
    println(e2)


    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
    println("$oneMillion, $creditCardNumber, $socialSecurityNumber, $hexBytes, $bytes")
}
