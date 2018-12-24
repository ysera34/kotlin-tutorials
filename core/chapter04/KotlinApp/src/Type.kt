fun main(args: Array<String>) {
    var a = 100
//    a = 123.45 // Error: The floating-point literal does not conform to the expected type Int

    val b: Int = 100 // Explicitly given type is redundant here
//    val c: Long = a // Error: Type mismatch. Required:Long, Found:Int
    val c: Long = b.toLong()
    val d: Long = b + 1L
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