fun main(args: Array<String>) {
    val m1 = Score(100, 200)
    val m2 = Score(300, 400)
    println(m1 + m2)
    println(m1 * m2)

    var a: Int = 0
    var b: Int = 100
    println("++a = ${++a}, b-- = ${b--}")
    println("++a = ${++a}, b-- = ${b--}")


    val m3 = Score(300, 400)
    val m4 = Score(300, 400)
    println(m2 == m3)
    println(m2 === m3)
    println(m2.equals(m3))


    val p1 = Customer("john", "010-1234-5678")
    val p2 = Customer("peter", "010-5678-1234")
    println(p1 < p2)
    println(p1 > p2)
}

data class Score(val a: Int, val b: Int) {
    operator fun plus(other: Score): Score {
        return Score(a + other.a, b + other.b)
    }
}

operator fun Score.times(other: Score): Score {
    return Score(a * other.a, b * other.b)
}

operator fun Score.unaryMinus(): Score {
    return Score(-a, -b)
}

class Customer(val name: String, val phone: String) : Comparable<Customer> {
    override fun compareTo(other: Customer): Int {
        return compareValuesBy(this, other, Customer::name, Customer::phone)
    }
}
