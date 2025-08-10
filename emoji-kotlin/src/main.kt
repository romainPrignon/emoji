package emoji

import emoji.core.*
import emoji.cli.*
import emoji.HttpClient.*
import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    val client = HttpClient()
    val core = Core(client)

    // stdout(core.run(stdin(args)))
    try {
        stdin(args)
            .let{core.run(it)}
            .let { emoji ->
                when {
                    emoji.isFailure -> "Error: invalid user input"
                    emoji.isSuccess -> emoji.getOrNull()
                    else -> throw IllegalStateException("unknow state")
                }
            }
            .let{stdout(it)}
    } catch (e: Exception) {
        stdout(e.message)
    }
}