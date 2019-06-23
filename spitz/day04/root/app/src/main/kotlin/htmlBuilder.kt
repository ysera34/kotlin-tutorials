import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.css.CSSStyleDeclaration
import kotlin.browser.document

abstract class Element(val tagName: String) {
    protected val element = when (tagName) {
        "body" -> document.body ?: throw Throwable("no body")
        else -> document.createElement(tagName) as HTMLElement
    }

    var html: String
        get() = element.innerHTML
        set(value) { element.innerHTML = value }
    val style: CSSStyleDeclaration
        get() = element.style

    operator fun get(key: String) = element.getAttribute(key) ?: ""
    operator fun set(key: String, value: Any) = element.setAttribute(key, "$value")
    operator fun invoke() = element
    operator fun plusAssign(child: Element) { element.appendChild(child.element) }
    operator fun minusAssign(child: Element) { element.removeChild(child.element) }
}

object Body : Element("body")
class Div : Element("div")
class Canvas : Element("canvas") {
    val context: CanvasRenderingContext2D?
        get() = (element as? HTMLCanvasElement)?.getContext("2d") as CanvasRenderingContext2D
}

fun htmlBuilder() {
    (0..5).map {
        Div().apply {
            html = "div-$it"
        }
    }.forEach {
        Body += it
    }

    Body += Canvas().apply {
        this["width"] = 500
        this["height"] = 500
        context?.run {
            lineWidth = 10.0
            strokeRect(75.0, 140.0, 150.0, 110.0)
            fillRect(130.0, 190.0, 40.0, 60.0)
            moveTo(50.0, 140.0)
            lineTo(150.0, 60.0)
            lineTo(250.0, 140.0)
            closePath()
            stroke()
        }
    }
}
