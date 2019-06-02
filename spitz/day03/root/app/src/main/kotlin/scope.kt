/*
    inline fun TODO(): Nothing
    inline fun TODO(reason: String): Nothing
    inline fun <R> run(block: () -> R): R
    inline fun <T, R> T.run(block: T.() -> R): R
    inline fun <T, R> with(receiver: T, block: T.() -> R): R
    inline fun <T> T.apply(block: T.() -> Unit): T
    inline fun <T> T.also(block: (T) -> Unit): T
    inline fun <T, R> T.let(block: (T) -> R): R
    inline fun <T> T.takeIf(predicate: (T) -> Boolean): T?
    inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T?
    inline fun repeat(times: Int, action: (Int) -> Unit)
 */

fun studyScope() {
    // TODO
    fun mock() {
        TODO("...")
    }
    // mock()

    // run
    // inline fun <R> run(block: () -> R): R
    // inline fun <T, R> T.run(block: T.() -> R): R
    val run0 = run {
        val a = 3
        val b = 5
        a + b
    }
    println("run0: $run0")
    val run1 = 15.run {
        val a = 3
        this + a
    }
    println("run1: $run1")

    // with
    // inline fun <T, R> with(receiver: T, block: T.() -> R): R
    val list1 = mutableListOf<String>()
    val with1 = with(list1) {
        list1.addAll("1, 2, 3, 4, 5, 6, 7".split(","))
        list1.first()
    }
    println("with1: $with1")

    // apply
    // inline fun <T> T.apply(block: T.() -> Unit): T
    val apply1 = mutableListOf(1, 2, 3).apply {
        forEachIndexed { index, i ->
            this[index] = i * 2
        }
    }
    println("apply1: $apply1")

    // also
    // inline fun <T> T.also(block: (T) -> Unit): T
    val also1 = mutableListOf(1, 2, 3).also {
        it.forEachIndexed { index, i ->
            it[index] = i * 2
        }
    }
    println("also1: $also1")

    // let
    // inline fun <T, R> T.let(block: (T) -> R): R
    val v1: Int? = null
    val double: (Int) -> Int = { it * 2 }
    if (v1 != null) println("${double(v1)}")
    v1?.let {
        println("${double(it)}")
    }
    val v2 = v1?.let { double(it) } ?: 0

    // takeIf & takeUnless
    // inline fun <T> T.takeIf(predicate: (T) -> Boolean): T?
    // inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T?
    val takeList = mutableListOf(1, 2, 3)
    val takeIf0 = if (takeList.size > 2) takeList else null
    println("takeIf0: $takeIf0")
    val takeIf1 = takeList.takeIf { it.size > 2 }
    println("takeIf1: $takeIf1")
    val takeUnless0 = if (takeList.size > 2) null else takeList
    println("takeUnless0: $takeUnless0")
    val takeUnless1 = takeList.takeUnless { it.size > 2 }
    println("takeUnless1: $takeUnless1")

    // repeat
    // inline fun repeat(times: Int, action: (Int) -> Unit)
    var i = 0
    val repeatList0 = mutableListOf<Int>()
    while (i < 10) {
        repeatList0.add(i)
        i++
    }
    println("repeatList0: $repeatList0")
    val repeatList1 = mutableListOf<Int>()
    repeat(10) {
        repeatList1.add(it)
    }
    println("repeatList1: $repeatList1")
}
