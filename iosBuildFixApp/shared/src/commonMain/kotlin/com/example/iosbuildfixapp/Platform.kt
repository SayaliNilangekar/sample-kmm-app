package com.example.iosbuildfixapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform