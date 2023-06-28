package com.example.iosbuildfixapp

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private val client = HttpClient() {
    install(ContentNegotiation){
        json(Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
        })
    }
}

suspend fun getResponse(): List<myResponse> {
    val response = client.get("https://official-joke-api.appspot.com/jokes/programming/random")
    println(response)
    println(response.bodyAsText())
    return response.body()
}