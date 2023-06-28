package com.example.iosbuildfixapp

class Title {
    private val platform: Platform = getPlatform()

    fun title(): String {
        return "Joke of the day for ${platform.name}!"
    }
}