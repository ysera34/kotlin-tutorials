import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap
import kotlin.collections.LinkedHashSet

fun main(args: Array<String>) {

    /**
     * List
     */
    var ls = listOf("1", "2", "3", "4")
    // ls.set(0, "5")
    println("listOf: $ls")

    ls = listOfNotNull("1", "2", "3", "4", null)
    println("listOfNotNull: $ls")

    var ml = mutableListOf("1", "2", "3", "4")
    println("mutableListOf: $ml")

    ml.set(0, "5")
    ml[0] = "5"
    println("mutableListOf: $ml")

    ml.remove("2")
    println("mutableListOf: $ml")

    var al = arrayListOf("1", "2", "3", "4")
    println("arrayListOf: $al")

    al.set(0, "5")
    println("arrayListOf: $al")

    al.remove("2")
    println("arrayListOf: $al")

    var ar = ArrayList<String>(ls)
    println("ArrayList: $ar")

    ar.set(0, "5")
    println("ArrayList: $ar")

    ar.remove("2")
    println("ArrayList: $ar")

    var ll = LinkedList<String>()
    ll.add("1")
    ll.add("2")
    ll.add("3")
    ll.add("4")
    println("LinkedList: $ll")

    ll.set(0, "5")
    println("LinkedList: $ll")

    ll.remove("2")
    println("LinkedList: $ll")

    /**
     * Set
     */
    var st = setOf("3", "2", "1", "4", "2")
    // st.remove("4")
    println("setOf: $st")

    var ms = mutableSetOf("3", "2", "1", "4", "2")
    ms.remove("4")
    println("mutableSetOf: $ms")

    var hs = hashSetOf("3", "2", "1", "4", "2")
    hs.remove("4")
    println("hashSetOf: $hs")

    var lk = linkedSetOf("3", "2", "1", "4", "2")
    lk.remove("4")
    println("linkedSetOf: $lk")

    var sr = sortedSetOf("3", "2", "1", "4", "2")
    sr.remove("4")
    println("sortedSetOf: $sr")

    var hss = HashSet(st)
    hss.remove("4")
    println("HashSet: $hss")

    var lhs = LinkedHashSet(st)
    lhs.remove("4")
    println("LinkedHashSet: $lhs")

    /**
     * Map
     */
    var mp = mapOf(Pair("1", "one"), Pair("2", "two"), Pair("3", "three"), Pair("4", "four"))
    // mp.remove("4")
    println("mapOf: $mp")

    val mt = mutableMapOf("1" to "one", "2" to "two", "3" to "three", "4" to "four")
    mt.remove("4")
    println("mutableMapOf: $mt")

    val hm = hashMapOf("1".to("one"), "2".to("two"), "3".to("three"), "4".to("four"))
    hm.remove("4")
    println("hashMapOf: $hm")

    var lm = linkedMapOf(Pair("1", "one"), Pair("2", "two"), Pair("3", "three"), Pair("4", "four"))
    lm.remove("4")
    println("linkedMapOf: $lm")

    var sm = sortedMapOf(Pair("1", "one"), Pair("2", "two"), Pair("3", "three"), Pair("4", "four"))
    sm.remove("4")
    println("sortedMapOf: $sm")

    var hsm = HashMap(mp)
    hsm.remove("4")
    println("HashMap: $hsm")

    var lhm = LinkedHashMap(mp)
    lhm.remove("4")
    println("LinkedHashMap: $lhm")
}
