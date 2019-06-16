fun mapDelegationTest() {
    val mapDelegation = MapDelegation(mutableMapOf("a" to "abc", "b" to 3))
    println("mapDelegation - map: ${mapDelegation.a}")
    println("mapDelegation - map: ${mapDelegation.b}")

    mapDelegation.map = mutableMapOf("a" to "def", "b" to 5)
    println("mapDelegation - map: ${mapDelegation.a}")
    println("mapDelegation - map: ${mapDelegation.b}")
}

class MapDelegation(var map: MutableMap<String, Any?>) {
    val a: String by map
    val b: Int by map
}
