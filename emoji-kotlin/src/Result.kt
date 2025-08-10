package emoji

import kotlinx.serialization.Serializable

@Serializable
data class EmojiResult(val character: String)