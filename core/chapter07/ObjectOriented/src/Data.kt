fun main(args: Array<String>) {
    val f1 = FriendData("ally", 20, "000")
    val f2 = FriendData("jack", 21, "111")

    println(f1)
    println(f2)

    println(f1 == f2)
    println(f1.hashCode() == f2.hashCode())

    val f3 = f2.copy(tel = "222")
    println(f3)
    println(f3 == f2)
    println(f3 === f2)

    // destructuring declaration
    val (name, age, tel) = f1
    println("$name, $age, $tel")
    println("${f1.component1()}, ${f1.component2()}, ${f1.component3()}")
}

data class FriendData(val name: String, val age: Int, val tel: String)
