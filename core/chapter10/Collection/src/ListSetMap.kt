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
    println("listOf: ${ls.javaClass.canonicalName}, elements: $ls")

    ls = listOfNotNull("1", "2", "3", "4", null)
    println("listOfNotNull: $ls")
    println("listOfNotNull: ${ls.javaClass.canonicalName}, elements: $ls")

    var ml = mutableListOf("1", "2", "3", "4")
    println("mutableListOf: $ml")

    ml.set(0, "5")
    ml[0] = "5"
    println("mutableListOf: $ml")

    ml.remove("2")
    println("mutableListOf: $ml")
    println("mutableListOf: ${ml.javaClass.canonicalName}, elements: $ml")

    var al = arrayListOf("1", "2", "3", "4")

    al.set(0, "5")
    println("arrayListOf: $al")

    al.remove("2")
    println("arrayListOf: $al")
    println("arrayListOf: ${al.javaClass.canonicalName}, elements: $al")

    var ar = ArrayList<String>(ls)
    println("ArrayList: $ar")

    ar.set(0, "5")
    println("ArrayList: $ar")

    ar.remove("2")
    println("ArrayList: $ar")
    println("ArrayList: ${ar.javaClass.canonicalName}, elements: $ar")

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
    println("LinkedList: ${ll.javaClass.canonicalName}, elements: $ll")

    /**
     * Set
     */
    var st = setOf("3", "2", "1", "4", "2")
    // st.remove("4")
    println("setOf: $st")
    println("setOf: ${st.javaClass.canonicalName}, elements: $st")

    var ms = mutableSetOf("3", "2", "1", "4", "2")
    ms.remove("4")
    println("mutableSetOf: $ms")
    println("mutableSetOf: ${ms.javaClass.canonicalName}, elements: $ms")

    var hs = hashSetOf("3", "2", "1", "4", "2")
    hs.remove("4")
    println("hashSetOf: $hs")
    println("hashSetOf: ${hs.javaClass.canonicalName}, elements: $hs")

    var lk = linkedSetOf("3", "2", "1", "4", "2")
    lk.remove("4")
    println("linkedSetOf: $lk")
    println("linkedSetOf: ${lk.javaClass.canonicalName}, elements: $lk")

    var sr = sortedSetOf("3", "2", "1", "4", "2")
    sr.remove("4")
    println("sortedSetOf: $sr")
    println("sortedSetOf: ${sr.javaClass.canonicalName}, elements: $sr")

    var hss = HashSet(st)
    hss.remove("4")
    println("HashSet: $hss")
    println("HashSet: ${hss.javaClass.canonicalName}, elements: $hss")

    var lhs = LinkedHashSet(st)
    lhs.remove("4")
    println("LinkedHashSet: $lhs")
    println("LinkedHashSet: ${lhs.javaClass.canonicalName}, elements: $lhs")

    /**
     * Map
     */
    var mp = mapOf(Pair("1", "one"), Pair("2", "two"), Pair("3", "three"), Pair("4", "four"))
    // mp.remove("4")
    println("mapOf: $mp")
    println("mapOf: ${mp.javaClass.canonicalName}, elements: $mp")

    val mt = mutableMapOf("1" to "one", "2" to "two", "3" to "three", "4" to "four")
    mt.remove("4")
    println("mutableMapOf: $mt")
    println("mutableMapOf: ${mt.javaClass.canonicalName}, elements: $mt")

    val hm = hashMapOf("1".to("one"), "2".to("two"), "3".to("three"), "4".to("four"))
    hm.remove("4")
    println("hashMapOf: $hm")
    println("hashMapOf: ${hm.javaClass.canonicalName}, elements: $hm")

    var lm = linkedMapOf(Pair("1", "one"), Pair("2", "two"), Pair("3", "three"), Pair("4", "four"))
    lm.remove("4")
    println("linkedMapOf: $lm")
    println("linkedMapOf: ${lm.javaClass.canonicalName}, elements: $lm")

    var sm = sortedMapOf(Pair("1", "one"), Pair("2", "two"), Pair("3", "three"), Pair("4", "four"))
    sm.remove("4")
    println("sortedMapOf: $sm")
    println("sortedMapOf: ${sm.javaClass.canonicalName}, elements: $sm")

    var hsm = HashMap(mp)
    hsm.remove("4")
    println("HashMap: $hsm")
    println("HashMap: ${hsm.javaClass.canonicalName}, elements: $hsm")

    var lhm = LinkedHashMap(mp)
    lhm.remove("4")
    println("LinkedHashMap: $lhm")
    println("LinkedHashMap: ${lhm.javaClass.canonicalName}, elements: $lhm")
}
