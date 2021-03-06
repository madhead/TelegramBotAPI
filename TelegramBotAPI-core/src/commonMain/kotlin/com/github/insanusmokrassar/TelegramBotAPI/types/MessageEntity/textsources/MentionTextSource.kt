package com.github.insanusmokrassar.TelegramBotAPI.types.MessageEntity.textsources

import com.github.insanusmokrassar.TelegramBotAPI.CommonAbstracts.MultilevelTextSource
import com.github.insanusmokrassar.TelegramBotAPI.CommonAbstracts.TextPart
import com.github.insanusmokrassar.TelegramBotAPI.utils.*

private val String.withoutCommercialAt
    get() = if (startsWith("@")) {
        substring(1)
    } else {
        this
    }

class MentionTextSource(
    override val source: String,
    textParts: List<TextPart>
) : MultilevelTextSource {
    override val textParts: List<TextPart> by lazy {
        source.withoutCommercialAt.fullListOfSubSource(
            textParts.shiftSourcesToTheLeft(1)
        )
    }
    override val asMarkdownSource: String by lazy { source.mentionMarkdown() }
    override val asMarkdownV2Source: String by lazy { mentionMarkdownV2() }
    override val asHtmlSource: String by lazy { mentionHTML() }
}
