package emoji.core

import emoji.HttpClient.*
import kotlinx.coroutines.*
import emoji.EmojiResult

class InvalidUserInputException: Exception("Error: invalid user input")

class Core(val client: HttpClient) {
    private suspend  fun doQuery (word: String): HttpResponse {
        return client.get("http://emoji.getdango.com/api/emoji", object: Options {
            override val params = object: Params {
                override val search = word
                override val accessKey = "sggnzgohrgierg"
            }
        })
    }

    private suspend fun parseJson (response: HttpResponse): Array<EmojiResult> {
        return response.body()
    }
    
    private fun filterBestEmoji (result: Array<EmojiResult>): String {
        check(result.isNotEmpty())
        
        return result[0].character
    }

    suspend fun run (word: String?): Result<String> {
        if (word == null || word.isBlank()) return Result.failure(InvalidUserInputException())

        val emoji = doQuery(word)
            .let{parseJson(it)}
            .let{filterBestEmoji(it)}

        return Result.success(emoji)
    }
}
