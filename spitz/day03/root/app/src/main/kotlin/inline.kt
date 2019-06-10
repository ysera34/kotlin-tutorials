fun studyBeforeInline() {
    fun pass(v: Int, block: (Int) -> Int) = block(v)
    println("${pass(3, { it * 2 })}")
    println("${pass(3) { it * 2 }}")
}

/* build in kotlin-js

  function studyBeforeInline$pass(v, block) {
    return block(v);
  }
  function studyBeforeInline$lambda(it) {
    return it * 2 | 0;
  }
  function studyBeforeInline$lambda_0(it) {
    return it * 2 | 0;
  }
  function studyBeforeInline() {
    var pass = studyBeforeInline$pass;
    println(pass(3, studyBeforeInline$lambda).toString());
    println(pass(3, studyBeforeInline$lambda_0).toString());
  }
 */

fun studyAfterInline() {
    inline fun pass(v: Int, block: (Int) -> Int) = block(v)
    println("${pass(3, { it * 2 })}")
    println("${pass(3) { it * 2 }}")
}

/* build in kotlin-js

  function studyAfterInline() {
    println((3 * 2 | 0).toString());
    println((3 * 2 | 0).toString());
  }
 */

fun tryInlineFun() {

    fun ifTrue(v: Boolean, block: () -> Unit) { if (v) block() }
    ifTrue(true, { println("true") })
    ifTrue(true) { println("true") }
    inline fun inlineIfTrue(v: Boolean, block: () -> Unit) { if (v) block() }
    inlineIfTrue(true, { println("true") })
    inlineIfTrue(true) { println("true") }

    fun <T> reverseFor(v: List<T>, block: (T) -> Unit) {
        var i = v.size
        while (i-- > 0) block(v[i])
    }
    reverseFor(listOf("a", "b", "c"), ::println) // function reference operator
    inline fun <T> inlineReverseFor(v: List<T>, block: (T) -> Unit) {
        var i = v.size
        while (i-- > 0) block(v[i])
    }
    inlineReverseFor(listOf("a", "b", "c"), ::println)
}

/* build in kotlin-js

  var Unit = Kotlin.kotlin.Unit;
  var listOf = Kotlin.kotlin.collections.listOf_i5x0yv$;
  var getCallableRef = Kotlin.getCallableRef;

  function tryInlineFun$ifTrue(v, block) {
    if (v)
      block();
  }
  function tryInlineFun$lambda() {
    println('true');
    return Unit;
  }
  function tryInlineFun$lambda_0() {
    println('true');
    return Unit;
  }
  function tryInlineFun$reverseFor(v, block) {
    var tmp$;
    var i = v.size;
    while ((tmp$ = i, i = tmp$ - 1 | 0, tmp$) > 0)
      block(v.get_za3lpa$(i));
  }
  function tryInlineFun() {
    var ifTrue = tryInlineFun$ifTrue;
    ifTrue(true, tryInlineFun$lambda);
    ifTrue(true, tryInlineFun$lambda_0);
    if (true) {
      println('true');
    }
    if (true) {
      println('true');
    }
    var reverseFor = tryInlineFun$reverseFor;
    reverseFor(listOf(['a', 'b', 'c']), getCallableRef('println', function (message) {
      return println(message), Unit;
    }));
    var v = listOf(['a', 'b', 'c']);
    var tmp$;
    var i = v.size;
    while ((tmp$ = i, i = tmp$ - 1 | 0, tmp$) > 0) {
      println(v.get_za3lpa$(i));
    }
  }
 */
