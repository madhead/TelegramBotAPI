package com.github.insanusmokrassar.TelegramBotAPI.types.InlineQueries.InlineQueryResult.abstracts.results.mpeg4gif

import com.github.insanusmokrassar.TelegramBotAPI.CommonAbstracts.Captioned
import com.github.insanusmokrassar.TelegramBotAPI.types.InlineQueries.InlineQueryResult.abstracts.*

const val inlineQueryResultMpeg4GifType = "mpeg4_gif"

interface InlineQueryResultMpeg4GifCommon : InlineQueryResult,
    OptionallyTitledInlineQueryResult,
    Captioned,
    WithInputMessageContentInlineQueryResult
