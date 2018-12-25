fun main(args: Array<String>) {
    val intItem1 = arrayOf(arrayOf(0, 0, 0), arrayOf(0, 0, 0))
    val intItem2 = Array(2, { Array(3, { i -> 0 } ) })
    val intItem3 = Array(2) { Array(3) { i -> 0 } }

    val intItem4: Array<Array<Int>> = arrayOf(arrayOf(0, 0, 0), arrayOf(0, 0, 0))
    val intItem5: Array<Array<Int>> = Array(2, { Array(3, { i -> 0 } ) })
    val intItem6: Array<Array<Int>> = Array(2) { Array(3) { i -> 0 } }

    val intItem7 = Array(5) { i -> Array(5) { j -> 10 * i + (j + 1) } }
    printArray(intItem7)
    printArray(createArray(5, 5))
}

fun createArray(row: Int, col: Int): Array<Array<Int>> {
    val newArray = Array(row) { Array(col) { i -> 0 }}

    var rowValue = 1
    for (x in 0..row - 1) {
        for (y in 0..col - 1) {
            newArray[x][y] = rowValue + y
        }
        rowValue += 10
    }
    return newArray
}

fun printArray(arr: Array<Array<Int>>) {
    for (x in 0..arr.size - 1) {
        for (y in 0..arr[x].size - 1) {
            print("${arr[x][y]} ")
        }
        println()
    }
}
