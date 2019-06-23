fun builder() {
//    val request = RequestBuilder("http://apiServer")
//            .method(Method.POST)
//            .form("name", "kotlin")
//            .form("email", "kotlin@email.com")
//            .timeout(5000)
//            .ok {  }
//            .fail {  }
//            .build()

    val withRequest = with(RequestBuilder("http://apiServer")) {
        method(Method.POST)
        form("name", "kotlin")
        form("email", "kotlin@email.com")
        timeout(5000)
        ok { }
        fail { }
        build()
    }

    val applyRequest1 = applyRequestBuilder("http://apiServer") {
        method(Method.POST)
        form("name", "kotlin")
        form("email", "kotlin@email.com")
        timeout(5000)
        ok { }
        fail { }
        build()
    }

    val applyRequest2 = RequestBuilder("http://apiServer") {
        method = Method.POST
        form["name"] = "kotlin"
        form["email"] = "kotlin@email.com"
        timeout = 5000
        ok = { }
        fail = { }
    }
}
typealias Listener = (String) -> Unit

enum class Method {
    POST,
    GET
}

class Request(
    val url: String,
    val method: Method,
    val form: MutableMap<String, String>?,
    val timeout: Int,
    val ok: Listener?, // val ok: ((String) -> Unit)?,
    val fail: Listener? // val fail: ((String) -> Unit)?
)

class RequestBuilder(private val url: String) {
    var method: Method = Method.GET
    val form = mutableMapOf<String, String>()
    var timeout = 0
    var ok: Listener? = null // private var ok: ((String) -> Unit)? = null
    var fail: Listener? = null // private var fail: ((String) -> Unit)? = null

//    fun method(method: Method): RequestBuilder {
//        this.method = method
//        return this
//    }

//    fun method(method: Method) = run {
//        this.method = method
//        this
//    }

    fun method(method: Method) {
        this.method = method
    }

//    fun form(key: String, value: String): RequestBuilder {
//        this.form[key] = value
//        return this
//    }

//    fun form(key: String, value: String) = run {
//        this.form[key] = value
//        this
//    }

    fun form(key: String, value: String) {
        this.form[key] = value
    }

//    fun timeout(ms: Int): RequestBuilder {
//        this.timeout = ms
//        return this
//    }

//    fun timeout(ms: Int) = run {
//        this.timeout = ms
//        this
//    }

    fun timeout(ms: Int) {
        this.timeout = ms
    }

//    fun ok(block: Listener /*(String) -> Unit*/): RequestBuilder {
//        this.ok = block
//        return this
//    }

//    fun ok(block: Listener /*(String) -> Unit*/) = run {
//        this.ok = block
//        this
//    }

    fun ok(block: Listener) {
        this.ok = block
    }

//    fun fail(block: Listener /*(String) -> Unit*/): RequestBuilder {
//        this.fail = block
//        return this
//    }

//    fun fail(block: Listener /*(String) -> Unit*/) = run {
//        this.fail = block
//        this
//    }

    fun fail(block: Listener) {
        this.fail = block
    }

    fun build() = Request(url, method, if (form.isEmpty()) null else form, timeout, ok, fail)
    fun build1() = Request(url, method, form.takeIf { it.isNotEmpty() }, timeout, ok, fail)
    fun build2() = Request(url, method, form.takeUnless { it.isEmpty() }, timeout, ok, fail)
}

fun applyRequestBuilder(url: String, block: RequestBuilder.() -> Unit) = RequestBuilder(url).apply(block).build()
fun RequestBuilder(url: String, block: RequestBuilder.() -> Unit) = RequestBuilder(url).apply(block).run {
    Request(url, method, form.takeIf { it.isNotEmpty() }, timeout, ok, fail)
}
