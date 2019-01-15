//val funSum: (Int, Int) -> Int = {x, y -> x + y}
//fun funExec1(func1: (Int, Int) -> Int): Double {  }
//fun funExec2(func2: (Int, Int) -> Int): (Int) -> Int {  }

fun main(args: Array<String>) {
    val sum: (Int, Int) -> Int = {x, y -> x + y}
    val lambdaList = ArrayList<(Int, Int) -> Int>()
    lambdaList.add(sum)

    val a: (Int, Int) -> Int = lambdaList[0]
    println(a(10, 20))

    println("${runLambda(sum)}")
}

fun runLambda(lambda: (Int, Int) -> Int): Int {
    val lambdaList = ArrayList<(Int, Int) -> Int>()
    lambdaList.add(lambda)
    val a = lambdaList[0]
    return a(10, 20)
}
