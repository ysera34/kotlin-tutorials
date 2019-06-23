import kotlinx.coroutines.suspendCancellableCoroutine
import org.w3c.fetch.Request
import kotlin.browser.window
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.js.Promise

suspend fun coroutineTest() {
    timeout(1000)
    println("a")
    println(task { it("b") })
    println("c")
    timeout(1000)
    println("d")

    val response1 = window.fetch(Request("../../resources/main/a.txt")).await()
    val text1 = response1.text().await()
    val response2 = window.fetch(Request(text1)).await()
    val text2 = response2.text().await()
    println(text2)

}

suspend fun <T> task(block: ((T) -> Unit) -> Unit): T = suspendCoroutine { continuation: Continuation<T> ->
    block {
        continuation.resume(it)
    }
}

suspend fun timeout(t: Int): Unit = task { window.setTimeout({ it(Unit) }, t) }

suspend fun <T> Promise<T>.await(): T = suspendCancellableCoroutine { continuation: Continuation<T> ->
    this.then(
        onFulfilled = { continuation.resume(it) },
        onRejected = { continuation.resumeWithException(it) }
    )
}
