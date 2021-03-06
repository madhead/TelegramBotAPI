package com.github.insanusmokrassar.TelegramBotAPI.extensions.api

import com.github.insanusmokrassar.TelegramBotAPI.bot.Ktor.KtorRequestsExecutor
import com.github.insanusmokrassar.TelegramBotAPI.bot.RequestsExecutor
import com.github.insanusmokrassar.TelegramBotAPI.utils.TelegramAPIUrlsKeeper
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine

/**
 * Allows to create bot using bot [urlsKeeper] and already prepared [client]
 */
fun telegramBot(
    urlsKeeper: TelegramAPIUrlsKeeper,
    client: HttpClient = HttpClient()
): RequestsExecutor = KtorRequestsExecutor(
    urlsKeeper,
    client
)

/**
 * Allows to create bot using bot [urlsKeeper] and specify [HttpClientEngine] by passing [clientEngine] param and optionally
 * configure [HttpClient] using [clientConfig]
 */
fun telegramBotWithCustomClientConfig(
    urlsKeeper: TelegramAPIUrlsKeeper,
    clientEngine: HttpClientEngine,
    clientConfig: HttpClientConfig<*>.() -> Unit = {}
): RequestsExecutor = telegramBot(
    urlsKeeper,
    HttpClient(clientEngine, clientConfig)
)

/**
 * Allows to create bot using bot [urlsKeeper] and optionally configure [HttpClient] using [clientConfig]
 */
fun telegramBotWithCustomClientConfig(
    urlsKeeper: TelegramAPIUrlsKeeper,
    clientConfig: HttpClientConfig<*>.() -> Unit = {}
): RequestsExecutor = telegramBot(
    urlsKeeper,
    HttpClient(clientConfig)
)

/**
 * Allows to create bot using bot [token]
 */
fun telegramBot(
    token: String
): RequestsExecutor = telegramBotWithCustomClientConfig(TelegramAPIUrlsKeeper(token))

/**
 * Allows to create bot using bot [token] and already prepared [client]
 */
fun telegramBot(
    token: String,
    client: HttpClient
): RequestsExecutor = telegramBot(TelegramAPIUrlsKeeper(token), client)

/**
 * Allows to create bot using bot [token] and configure [HttpClient] using [clientConfig]
 */
fun telegramBotWithCustomClientConfig(
    token: String,
    clientConfig: HttpClientConfig<*>.() -> Unit
): RequestsExecutor = telegramBotWithCustomClientConfig(TelegramAPIUrlsKeeper(token), clientConfig)

/**
 * Allows to create bot using bot [token] and specify [HttpClientEngine] by passing [clientEngine] param and optionally
 * configure [HttpClient] using [clientConfig]
 */
fun telegramBot(
    token: String,
    clientEngine: HttpClientEngine,
    clientConfig: HttpClientConfig<*>.() -> Unit = {}
): RequestsExecutor = telegramBotWithCustomClientConfig(TelegramAPIUrlsKeeper(token), clientEngine, clientConfig)
