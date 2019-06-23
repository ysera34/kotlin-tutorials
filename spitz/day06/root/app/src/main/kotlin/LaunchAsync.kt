import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

suspend fun launchTest() {
    GlobalScope.launch(
        context = EmptyCoroutineContext,
        start = CoroutineStart.DEFAULT
    ) {
        timeout(1000)
        println("GlobalScope.launch a")
    }
    GlobalScope.launch(
        context = Dispatchers.Default,
        start = CoroutineStart.DEFAULT
    ) {
        timeout(1000)
        println("GlobalScope.launch b")
    }.join()
    GlobalScope.launch(
            context = Dispatchers.Default,
            start = CoroutineStart.LAZY
    ) {
        timeout(1000)
        println("GlobalScope.launch c")
    }
    GlobalScope.launch(
        context = Dispatchers.Default,
        start = CoroutineStart.LAZY
    ) {
        timeout(1000)
        println("GlobalScope.launch d")
    }.start()
}

suspend fun asyncTest() {
    val a = GlobalScope.async(
        context = EmptyCoroutineContext,
        start = CoroutineStart.DEFAULT
    ) {
        timeout(1000)
        "GlobalScope.async a"
    }
    val b = GlobalScope.async(
        context = EmptyCoroutineContext,
        start = CoroutineStart.DEFAULT
    ) {
        timeout(1000)
        "GlobalScope.async b"
    }
    val c = GlobalScope.async(
            context = EmptyCoroutineContext,
            start = CoroutineStart.LAZY
    ) {
        timeout(1000)
        "GlobalScope.async c"
    }
    val d = GlobalScope.async(
            context = EmptyCoroutineContext,
            start = CoroutineStart.LAZY
    ) {
        timeout(1000)
        "GlobalScope.async d"
    }
    d.start()
    println(a.await())
    println(b.await())
    println(c.await())
    println(d.await())
}
