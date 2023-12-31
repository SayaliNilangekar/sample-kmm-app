package com.example.iosbuildfixapp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class myResponse(
    @SerialName("type")
    val type: String,
    @SerialName("setup")
    val setup: String,
    @SerialName("punchline")
    val punchline: String,
    @SerialName("id")
    val id: Int
)