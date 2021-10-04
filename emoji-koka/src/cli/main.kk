module cli/main

import std/os/env

public fun stdin(): <exn,ndet> string {
    val word = get-args().head()
    return unjust(word)
}

public fun stdout(output: string): console () {
    println(output)
}

fun run(runnable: (word: string) -> _e string) {
    return fn (word: string): _e string {
        return runnable(word)
    }
}

// equivalent ?
fun run2(runnable: (word: string) -> _e string, word: string): _e string {
    return runnable(word)
}

// pas sur que besoin (juste pour le fun)
fun main() {
    val runnable = fn (word: string) {
        return word
    }
    // val line = compose3(stdin, run(runnable), stdout)
    // return line()
    val runner = run(runnable)
    val sin = try {stdin()}
    println(sin.default("a"))
    // return stdout(runner(stdin()))
}

// private I need to implement, ou pas c'est par defaut dans le lang
// fun compose3<a,b,c,d>(f: (a) -> b, g: (b) -> c, h: (c) -> d) {
//     return fn (x: a): d {
//         return f(g(h(x)))
//     }
// }