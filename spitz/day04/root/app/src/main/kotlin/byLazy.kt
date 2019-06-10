fun byLazyTest() {
    val map = MapTest2()
//    println(map.name)
    map["firstName"] = "kotlin"
//    println(map.name)
    map["lastName"] = "language"
    println(map.name)
}

class MapTest2 {
    private val map = mutableMapOf<String, String>()
    operator fun get(key: String) = map[key]
    operator fun set(key: String, value: String) { map[key] = value }

    // public actual fun <T> lazy(initializer: () -> T): Lazy<T> = UnsafeLazyImpl(initializer)
    val name by lazy { "${map["firstName"]} ${map["lastName"]}" }
}
