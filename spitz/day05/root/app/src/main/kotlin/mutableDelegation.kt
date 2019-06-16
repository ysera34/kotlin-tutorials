import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun mutableDelegationTest() {
    NotNull().action("ABC")
    CustomMutableDelegator("CustomMutableDelegator::").action("abc")
}

interface ReadWriteProperty<in R, T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T
    operator fun setValue(thisRef: R, property: KProperty<*>, value: T)
}

private class NotNullVar<T: Any> : ReadWriteProperty<Any?, T> {
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("Property should be initialized before get.")
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
    }
}

class NotNull {
    var a: String by Delegates.notNull()
    lateinit var b: String
    fun action(v: String) {
        a = v
        b = v
        println("a: $a")
        println("b: $b")
    }
}

class Delegator(val deco: String) : ReadWriteProperty<Any?, String> {
    private var value: String? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$deco $value"
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.value = value
    }
}

class CustomMutableDelegator(deco: String) {
    var a by Delegator(deco)
    fun action(v: String) {
        a = v
        println(a)
    }
}
