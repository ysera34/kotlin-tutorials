import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun test() {
        val expectedString = "test string from lib"
        assertEquals(expectedString, testString())
    }
}
