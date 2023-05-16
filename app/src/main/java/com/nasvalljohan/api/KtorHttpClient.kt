package com.nasvalljohan.api

import io.ktor.client.* // ktlint-disable no-wildcard-imports
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

val ktorHttpClient = HttpClient(CIO) {
    expectSuccess = true
    install(ContentNegotiation) {
        Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
}
