import org.w3c.fetch.Request
import org.w3c.fetch.RequestInit
import kotlin.browser.window

class FetchParam {
    val queries = mutableMapOf<String, Any>()
    val headers = mutableMapOf<String, String>()
    val method = Method.GET

    enum class Method {
        GET, POST
    }
}

fun fetch(url: String, block: FetchParam.() -> Unit) = FetchParam().apply {
    block()
}.let {
    window.fetch(Request(url, RequestInit(
        method = it.method.name,
        headers = run {
            val obj: dynamic = js("{}")
            it.headers.forEach { (key, value) -> obj[key] = value }
            obj
        },
        body = if (it.method != FetchParam.Method.GET) {
            it.queries.toList().joinToString("&") {
                (key, value) -> "$key=$value"
            }
        } else {
            null
        }
    )))
}

fun fetchBuilder() {
    fetch("../../resources/test/test.json") {

    }.then {
        it.text()
    }.then {
        println(it)
    }
}
