fun continuationSequenceTest() {
    var continuation = continuation1(3)
    while (!continuation.isCompleted) {
        continuation = continuation1(3, continuation)
    }
    println(continuation.result)

    // sequence to iteration
    val s = sequence {
        var v = 3
        v++
        println("state $v")
        yield(v)
        v++
        println("state $v")
        yield(v)
        v++
        println("state $v")
        yield(v)
    }
    println(s.last())
}

class CustomContinuation<T> {
    var state = 0
    var isCompleted = false
    var result: T? = null

    fun resume(v: T) {
        state++
        result = v
    }

    fun complete(v: T) {
        isCompleted = true
        result = v
    }
}

fun continuation1(a: Int, continuation: CustomContinuation<Int>? = null) = run {
    var v: Int
    val c = if (continuation == null) {
        v = a
        CustomContinuation()
    } else {
        v = continuation.result!!
        continuation
    }

    when (c.state) {
        0 -> {
            v++
            println("state $v")
            c.resume(v)
        }
        1 -> {
            v++
            println("state $v")
            c.resume(v)
        }
        else -> {
            v++
            println("state $v")
            c.complete(v)
        }
    }
    c
}
