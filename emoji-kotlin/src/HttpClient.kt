package emoji.HttpClient

import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.coroutines.delay

import emoji.EmojiResult

class HttpResponse(val status: Int, val data: String) {
    inline suspend fun <reified T> body (): T =
        when (T::class) {
            String::class -> data as T
            else -> Json.decodeFromString<T>(data)
        }
}

interface Params {
    val search: String
    val accessKey: String
}

interface Options {
    val params: Params
}

class HttpClient {
    suspend fun get (url: String, options: Options): HttpResponse {
        delay(1000L)
        
        if (options.params.accessKey.isBlank()) {
            throw IllegalStateException("Access key is required")
        }

        val results: List<EmojiResult> = when (options.params.search) {
            "love" -> listOf(EmojiResult("♥ love"), EmojiResult("💚 green love"))
            "earth" -> listOf(EmojiResult("🌍 earth"), EmojiResult("🪐 saturn"))
            else -> throw IllegalStateException("Search term not found")
        }

        return HttpResponse(200, Json.encodeToString(results))
    }
}