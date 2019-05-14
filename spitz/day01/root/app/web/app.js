if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'app'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'app'.");
}
var app = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main() {
    println('hello world in app');
  }
  _.main = main;
  main();
  Kotlin.defineModule('app', _);
  return _;
}(typeof app === 'undefined' ? {} : app, kotlin);
