fun main(args: Array<String>) {
    val ls = listOf("1", "2", "3", "4")
    // ls.remove("2")

    val ml = mutableListOf("1", "2", "3", "4")
    ml.remove("2")

    val al = arrayListOf("1", "2", "3", "4")
    al.remove("2")

    val ar1 = ArrayList<String>(ls)
    ar1.remove("2")

    val ar2: MutableList<String> = ArrayList<String>(ls)
    ar2.remove("2")

    val ar3: List<String> = ArrayList<String>(ls)
    // ar3.remove("2")

    val ar4: ArrayList<String> = ArrayList<String>(ls)
    ar4.remove("2")
}
