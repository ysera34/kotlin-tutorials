lateinit var friend1: Friend1

fun main(args: Array<String>) {
//    Exception in thread "main" kotlin.UninitializedPropertyAccessException:
//    lateinit property friend1 has not been initialized
//    println("${friend1.name} ${friend1.tel}")

    friend1 = Friend1("john", "000")
    println("${friend1.name} ${friend1.tel}")
}
