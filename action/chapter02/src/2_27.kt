import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException

fun readNumber1(reader: BufferedReader): Int? {
    return try {
        val line = reader.readLine()
        Integer.parseInt(line)
    } catch (e: Exception) {
        null
    } finally {
        reader.close()
    }
}

fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }
    println(number)
}

fun readNumber3(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    println(number)
}

fun main(args: Array<String>) {
    val reader1 = BufferedReader(StringReader("239"))
    println(readNumber1(reader1))

    val reader2 = BufferedReader(StringReader("not a number"))
    readNumber2(reader2)

    val reader3 = BufferedReader(StringReader("not a number"))
    readNumber3(reader3)
}
