package emoji.cli

fun stdin (args: Array<String>): String? {
    // could have thrown here
    // this is just to show how tu use ?
    return args[0]
}

fun stdout (output: String?) {
    println(output)
}