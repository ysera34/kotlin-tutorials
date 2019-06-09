fun mapTest() {
    val map = Map()
    map["test"] = "123"
    println(map["test"])

    println(map.name)
    map["name"] = "kotlin"
    println(map.name)

    println(map.job)
    map.job = "developer"
    println(map.job)
}

class Map {
    private val map = mutableMapOf<String, String>()
    operator fun get(key: String) = map[key]
    operator fun set(key: String, value: String) { map[key] = value }

    val name: String? get() = map["name"]
    var job: String?
        get() = map["job"]
        set(value) { value?.let { map["job"] = it } }
}
