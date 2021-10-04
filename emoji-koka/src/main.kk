module main

import cli/main // c'est moche /main
import core/main

// // essayer de faire mon propre try !
// fun try2( action : () -> <exn|e> a, hndl: (exception) -> e a ) : e a {
//   with except throw-exn(exn){ hndl(exn) }
//   action()
// }

// // val handler = exception -> e a
// fun hand (truc: a): <console|e> () {
//   println("a")  
// }

// il fait donc gérer ces effets quelques part: unhandler de throw ?
public fun main(): io () {
  // val word = stdin()
  // val res = run(word)
  // return stdout(res)

  return stdout(run(stdin()))
  // return stdin().run().stdout()
}
