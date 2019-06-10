fun tryExtensionFun() {
    "  aaa  ".trim()
    // public inline fun String.trim(): String = (this as CharSequence).trim().toString()

    fun <T> MutableList<T>.pop() = if (isEmpty()) null else removeAt(lastIndex)
    val list = mutableListOf("a", "b", "c")
    val last = list.pop()
    println("last = $last, list = $list")
}

/* build in kotlin-js

  var get_lastIndex = Kotlin.kotlin.collections.get_lastIndex_55thoc$;
  var mutableListOf = Kotlin.kotlin.collections.mutableListOf_i5x0yv$;
  var toString = Kotlin.toString;
  var println = Kotlin.kotlin.io.println_s8jyv4$;

  function tryExtensionFun$pop($receiver) {
    return $receiver.isEmpty() ? null : $receiver.removeAt_za3lpa$(get_lastIndex($receiver));
  }
  var throwCCE = Kotlin.throwCCE;
  var trim = Kotlin.kotlin.text.trim_gw00vp$;
  function tryExtensionFun() {
    var tmp$;
    trim(Kotlin.isCharSequence(tmp$ = '  aaa  ') ? tmp$ : throwCCE()).toString();
    var pop = tryExtensionFun$pop;
    var list = mutableListOf(['a', 'b', 'c']);
    var last = pop(list);
    println('last = ' + toString(last) + ', list = ' + list);
  }
 */
