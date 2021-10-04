module core/main

import std/encoding/json

include extern {
  js file "main.js"
}

extern parse-result (str: string ): maybe<result> {
  js "parse_the_result"
}

extern stringify-result (res: result ): string {
  js "stringify_the_result"
}

struct result {
    foo: string
}

public fun run (word) {
    return do_query(word)
        .parse_json()
        .filter_best_emoji()
}

fun do_query (word: string): e string {
    return word
}

fun parse_json (json: a): <console|e> list<result> {
    // tant que generic marche pas
    // val jsonn: string = "{\"foo\": \"bar\"}"
    // println(jsonn)
    // val res: result = parse(jsonn, Result)
    // println(res.foo)
    // println(stringify(res))

    val jsonn: string = "{\"foo\": \"bar\"}"
    println(jsonn)
    val res = parse-result(jsonn)
    match(res) {
      Nothing -> println("")
      Just(r) -> println(r.foo)
    }
    match(res) {
      Nothing -> println("nothing to stringify")
      Just(r) -> println(stringify-result(r))
    }

    return list(1,1).map(fn(i) {Result(foo="this is foo")})
}

fun filter_best_emoji (res: list<result>): <exn|e> string {
    return res.map(fn(r) {r.foo }).head().unjust()
}
