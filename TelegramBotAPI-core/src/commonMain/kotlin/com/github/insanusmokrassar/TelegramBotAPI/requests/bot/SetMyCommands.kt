package com.github.insanusmokrassar.TelegramBotAPI.requests.bot

import com.github.insanusmokrassar.TelegramBotAPI.requests.abstracts.SimpleRequest
import com.github.insanusmokrassar.TelegramBotAPI.types.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.serializer

@Serializable
class SetMyCommands(
    @SerialName(botCommandsField)
    val commands: List<BotCommand>
) : SimpleRequest<Boolean> {
    override fun method(): String = "setMyCommands"
    override val resultDeserializer: DeserializationStrategy<Boolean>
        get() = Boolean.serializer()
    override val requestSerializer: SerializationStrategy<*>
        get() = serializer()

    init {
        if (commands.size !in botCommandsLimit) {
            error("Bot commands list size able to be in range $botCommandsLimit, but incoming size is ${commands.size}")
        }
    }
}
