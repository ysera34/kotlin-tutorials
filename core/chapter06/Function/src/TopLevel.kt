fun main(args: Array<String>) {
    printCount(1, 100)
    println("sum = $count")
}

fun printCount(from: Int, to: Int) {
    for (i in from..to) { count += i }
}

var count = 0
// private static int count;
// + getter, setter

val TAB1 = "\t"
// private static final java.lang.String TAB1;
// + getter

const val TAB2 = "\t"
// public static final java.lang.String TAB2;
