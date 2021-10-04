public module json

public fun foo () {}

include extern {
  js file "json.js"
}

public fun parse(str: string, const: (b) -> e a): e a {
  val res = iparse(str)

  return const(res)
}

extern iparse<a>( str: string ): e a {
  js "json_parse"
}

public extern stringify<a>( struc: a ): e string {
  js "json_stringify"
}