import kotlin.reflect.KProperty

fun immutableDelegationTest() {
    CustomImmutableDelegator("CustomImmutableDelegator:: abc").action()
    CustomKeys(mapOf("a" to 3, "b" to 5)).action()
}

interface Lazy<T> {
    val value: T
    fun isInitialized(): Boolean
    operator fun getValue(any: Any, property: KProperty<*>): T {
        return value
    }
}

class Immutable(override val value: String) : Lazy<String> {
    override fun isInitialized() = true
}

class CustomImmutableDelegator(string: String) {
    val a by Immutable(string)
    fun action() {
        println(a)
    }
}

class Keys<T>(map: Map<T, Any>) : Lazy<Set<T>> {
    override val value = map.keys
    override fun isInitialized() = true
}

class CustomKeys(private val map: Map<String, Any>) {
    val keys by Keys(map)
    fun action() {
        println("keys: $keys")
    }
}
