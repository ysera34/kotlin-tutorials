abstract class Node(val parent: Element?)

class Element(val tagName: String, parent: Element?) : Node(parent) {
    val attributes = mutableMapOf<String, String>()
    val children = mutableListOf<Node>()
}

class TextNode(val text: String, parent: Element?) : Node(parent)

fun parseHTML(html: String) = parse(Element("root", null), html)

val rex = """<([a-zA-Z]+)((?:\s+[a-zA-Z-]+(?:\s*=\s*"[^"]*")?)*)\s*/?""".toRegex()
fun parse(parent: Element, html: String): Element {
    if (html[0] != '<') {
        // Text
        return if (html.isEmpty()) {
            parent
        } else {
            val next = html.indexOf('<')
            parent.children += TextNode(html.substring(0, if (next == -1) html.length else next), parent)
            if (next == -1) {
                parent
            } else {
                parse(parent, html.substring(next))
            }
        }
    } else {
        val next = html.indexOf('>')
        if (html[1] == '/') {
            // </TAG>
            return if (parent.parent == null) {
                parent
            } else {
                parse(parent.parent, html.substring(next + 1))
            }
        } else {
            val isClose = html[next - 1] == '/'
            // isClose => <TAG/>
            // !isClose => <TAG>Element</TAG>
            val matches = rex.matchEntire(html.substring(0, next))?.groupValues!!
            val el = Element(matches[1], parent)
            if (matches[2].isNotBlank()) matches[2].trim().split(' ').forEach {
                if (it.contains('=')) {
                    val kv = it.split('=').map { it.trim() }
                    el.attributes[kv.first()] = kv.last().replace("\"", "")
                } else {
                    el.attributes[it] = "true"
                }
            }
            parent.children += el
            return parse(if (isClose) parent else el, html.substring(next + 1))
        }
    }
}

tailrec fun tailrecParse(parent: Element, html: String): Element =
    if (html[0] != '<') {
        // Text
        if (html.isEmpty()) {
            parent
        } else {
            val next = html.indexOf('<')
            parent.children += TextNode(html.substring(0, if (next == -1) html.length else next), parent)
            if (next == -1) {
                parent
            } else {
                tailrecParse(parent, html.substring(next))
            }
        }
    } else {
        val next = html.indexOf('>')
        if (html[1] == '/') {
            // </TAG>
            if (parent.parent == null) {
                parent
            } else {
                tailrecParse(parent.parent, html.substring(next + 1))
            }
        } else {
            val isClose = html[next - 1] == '/'
            // isClose => <TAG/>
            // !isClose => <TAG>Element</TAG>
            val matches = rex.matchEntire(html.substring(0, next))?.groupValues!!
            val el = Element(matches[1], parent)
            if (matches[2].isNotBlank()) matches[2].trim().split(' ').forEach {
                if (it.contains('=')) {
                    val kv = it.split('=').map { it.trim() }
                    el.attributes[kv.first()] = kv.last().replace("\"", "")
                } else {
                    el.attributes[it] = "true"
                }
            }
            parent.children += el
            tailrecParse(if (isClose) parent else el, html.substring(next + 1))
        }
    }

fun printElement(element: Element, indent: Int = 0) {
    element.children.forEach {
        if (it is Element) {
            println("${"-".repeat(indent)}Element ${it.tagName}")
            if (it.attributes.isNotEmpty()) {
                println("${" ".repeat(indent + 2)}Attributes ${
                    it.attributes.map { (k, v) -> "$k = '$v'" }.joinToString(" ")
                }")
            }
            printElement(it, indent + 1)
        } else if (it is TextNode) {
            println("${"-".repeat(indent)}Text '${it.text}'")
        }
    }
}
