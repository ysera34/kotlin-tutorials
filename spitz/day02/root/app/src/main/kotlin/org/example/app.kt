package org.example

import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.KeyboardEvent
import kotlin.browser.document

val cleanUp: Regex = """[^.\d-+*\/]""".toRegex()
val mulDiv: Regex = """((?:\+-)?[.\d]+)([*\/])((?:\+-)?[.\d]+)""".toRegex()
val paren = """\(([^()]*)\)""".toRegex()

fun calc(string: String): Double {
    var r = string
    while(paren.containsMatchIn(r)) r = r.replace(paren) {
        "${calculate(it.groupValues[1])}"
    }
    return calculate(r)
}

fun calculate(string: String): Double {
    return string
            .replace(cleanUp, "")
            .replace("-", "+-")
            .replace(mulDiv) {
                val (_, left, op, right) = it.groupValues
                val l = left.replace("+", "").toDouble()
                val r = right.replace("+", "").toDouble()
                "${if(op == "*") l * r else l / r}".replace("-", "+-")
            }.split('+').fold(0.0) { sum, v ->
                sum + if(v.isBlank()) 0.0 else v.toDouble()
            }
}

fun app() {
    document.querySelector("#base")?.innerHTML = """
        <input id="input" />
        <div id="result"><ul></ul></div>
    """.trimIndent()
    document.querySelector("#input")?.addEventListener("keyup", {
        if ((it as KeyboardEvent).keyCode != 13) return@addEventListener
        val input = it.target as HTMLInputElement
        val value = input.value
        val resultUnOrderedList = document.querySelector("#result")?.firstChild
        val resultListItem = document.createElement("li")
        val result = document.createTextNode("$value = ${calc(value)}")
        resultListItem.appendChild(result)
        resultUnOrderedList?.appendChild(resultListItem)
        input.value = ""
    })
}
