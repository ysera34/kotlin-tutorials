import org.w3c.fetch.Request
import org.w3c.fetch.Response
import kotlin.browser.window
import kotlin.js.Promise
import kotlin.collections.Iterator

fun coTest() {
    co(seq = sequence {
        val s = State()
        s.target = window.fetch(Request("../../resources/main/a.txt"))
        yield(s)
        s.target = window.fetch(Request(s.result))
        yield(s)
        println(s.result)
    })
}

class State {
    var result = ""
    lateinit var target: Promise<Response>
}

fun co(it: Iterator<State>? = null, seq: Sequence<State>? = null) {
    val iterator: Iterator<State> = it ?: seq?.iterator() ?: throw Throwable("invalid")
    if (iterator.hasNext()) iterator.next().let { state ->
        state.target.then {
            it.text()
        }.then {
            state.result = it
            co(iterator)
        }
    }
}
