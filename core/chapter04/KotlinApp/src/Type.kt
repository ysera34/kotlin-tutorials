fun main(args: Array<String>) {
    var a = 100
//    a = 123.45 // Error: The floating-point literal does not conform to the expected type Int

    val b: Int = 100 // Explicitly given type is redundant here
//    val c: Long = a // Error: Type mismatch. Required:Long, Found:Int
    val c: Long = b.toLong()
    val d: Long = b + 1L

    stringType()
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