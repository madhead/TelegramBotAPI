package com.github.insanusmokrassar.TelegramBotAPI.requests.answers

import com.github.insanusmokrassar.TelegramBotAPI.requests.abstracts.SimpleRequest
import com.github.insanusmokrassar.TelegramBotAPI.types.*
import com.github.insanusmokrassar.TelegramBotAPI.types.InlineQueries.InlineQueryResult.abstracts.InlineQueryResult
import com.github.insanusmokrassar.TelegramBotAPI.types.InlineQueries.InlineQueryResult.serializers.InlineQueryResultSerializer
import com.github.insanusmokrassar.TelegramBotAPI.types.InlineQueries.abstracts.InlineQuery
import kotlinx.serialization.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
data class AnswerInlineQuery(
    @SerialName(inlineQueryIdField)
    val inlineQueryID: InlineQueryIdentifier,
    @Serializable(InlineQueryAnswersResultsSerializer::class)
    @SerialName(resultsField)
    val results: List<InlineQueryResult> = emptyList(),
    @SerialName(cachedTimeField)
    val cachedTime: Int? = null,
    @SerialName(isPersonalField)
    val isPersonal: Boolean? = null,
    @SerialName(nextOffsetField)
    val nextOffset: String? = null,
    @SerialName(switchPmTextField)
    val switchPmText: String? = null,
    @SerialName(switchPmParameterField)
    val switchPmParameter: String? = null
): SimpleRequest<Boolean> {
    override fun method(): String = "answerInlineQuery"
    override val resultDeserializer: DeserializationStrategy<Boolean>
        get() = Boolean.serializer()
    override val requestSerializer: SerializationStrategy<*>
        get() = serializer()
}

fun InlineQuery.createAnswer(
    results: List<InlineQueryResult> = emptyList(),
    cachedTime: Int? = null,
    isPersonal: Boolean? = null,
    nextOffset: String? = null,
    switchPmText: String? = null,
    switchPmParameter: String? = null
) = AnswerInlineQuery(
    id,
    results,
    cachedTime,
    isPersonal,
    nextOffset,
    switchPmText,
    switchPmParameter
)

internal object InlineQueryAnswersResultsSerializer: KSerializer<List<InlineQueryResult>> by ListSerializer(
    InlineQueryResultSerializer
)
