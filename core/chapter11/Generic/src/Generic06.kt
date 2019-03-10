fun <T> printAny(ls: List<T>) = ls.forEach { print("$it ") }

fun printInt(ls: List<Int>) = ls.forEach { print("$it ") }

fun printNumber(ls: List<Number>) = ls.forEach { print("$it ") }

fun printMutableList(ls: MutableList<Number>) = ls.forEach { print("$it ") }

class Invariance<T> {}

class CoVariance<out T> {}

class ContraVariance<in T> {}

class Star<T> {}

/**
 * star projection
 * Useful for functions where the type of the argument is not important.
 */
fun printListItem(list: MutableList<*>) {
    println("elements size: ${list.size}")
    println("elements: $list")
//    list.add(100) Out-projected type 'MutableList<*>' prohibits the use of 'public abstract fun add(element: E): Boolean defined in kotlin.collections.MutableList'
}

fun main(args: Array<String>) {
    val lt1 = listOf<Int>(1, 2)
    val lt2 = listOf<Int?>(1, 2)
    val lt3 = listOf<Double>(1.0, 2.0)
    val lt4 = listOf<Double?>(1.0, 2.0)
    val lt5 = listOf<String>("1.0", "2.0")
    val lt6 = listOf<String?>("1.0", "2.0")

    println("\n ${printAny(lt1)}")
    println("\n ${printAny(lt2)}")
    println("\n ${printAny(lt3)}")
    println("\n ${printAny(lt4)}")
    println("\n ${printAny(lt5)}")
    println("\n ${printAny(lt6)}")

    println("\n ${printInt(lt1)}")
//    println("\n ${printInt(lt2)}") // Type mismatch. Required: List<Int> Found: List<Int?>
//    println("\n ${printInt(lt3)}") // Type mismatch. Required: List<Int> Found: List<Double>
//    println("\n ${printInt(lt4)}") // Type mismatch. Required: List<Int> Found: List<Double?>
//    println("\n ${printInt(lt5)}") // Type mismatch. Required: List<Int> Found: List<String>
//    println("\n ${printInt(lt6)}") // Type mismatch. Required: List<Int> Found: List<String?>

    println("\n ${printNumber(lt1)}")
//    println("\n ${printNumber(lt2)}") // Type mismatch. Required: List<Number> Found: List<Int?>
    println("\n ${printNumber(lt3)}")
//    println("\n ${printNumber(lt4)}") // Type mismatch. Required: List<Number> List<Double?>
//    println("\n ${printNumber(lt5)}") // Type mismatch. Required: List<Number> Found: List<String>
//    println("\n ${printNumber(lt6)}") // Type mismatch. Required: List<Number> Found: List<String?>

    /**
     * invariance
     */
    val mList1: MutableList<Int> = mutableListOf(1, 2)
    val mList2: MutableList<Double> = mutableListOf(1.0, 2.0)
    val mList3: MutableList<Number> = mutableListOf(1, 2.0)

//    println("\n ${printMutableList(mList1)}") // Type mismatch. Required: MutableList<Number> Found: MutableList<Int>
//    println("\n ${printMutableList(mList2)}") // Type mismatch. Required: MutableList<Number> Found: MutableList<Double>
    println("\n ${printMutableList(mList3)}")

    /**
     * declaration-site variance
     * (invariance, covariance and contravariance
     */
    val in1 = Invariance<Int>()
//    val in2: Invariance<Number> = in1 // Type mismatch. Required: Invariance<Number> Found: Invariance<Int>

    val co1 = CoVariance<Int>()
    val co2: CoVariance<Number> = co1

    val ct1 = ContraVariance<Int>()
//    val ct2: ContraVariance<Number> = ct1 // Type mismatch. Required: ContraVariance<Number> Found: ContraVariance<Int>
    val ct3 = ContraVariance<Number>()
    val ct4: ContraVariance<Int> = ct3

    /**
     * use-site variance
     * Not available in covariance, contravariance
     * (Conflicts with existing declarations)
     */
    val in3: Invariance<out Number> = in1

    /**
     * star projection
     */
    val st1: Star<Any> = Star<Any>()
//    val st2: Star<Any> = Star<Int>() // Type mismatch. Required: Star<Any> Found: Star<Int>
//    val st3: Star<Any> = Star<Number>() // Type mismatch. Required: Star<Any> Found: Star<Number>

//    val st4: Star<Any> = Star<String>() // Type mismatch. Required: Star<Any> Found: Star<String>
    val st5: Star<out Any> = Star<String>() // use-site variance

    val st6: Star<*> = Star<Any>()
    val st7: Star<*> = Star<Int>()
    val st8: Star<*> = Star<Number>()
    val st9: Star<*> = Star<String>()

    val ls1 = mutableListOf("james", "peter")
    val ls2 = mutableListOf(1, 2, 3, 4, 5)
    printListItem(ls1)
    printListItem(ls2)
}
