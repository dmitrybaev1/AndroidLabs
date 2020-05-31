package com.example.lab6.entities

data class Snippet(
    val publishedAt: String,
    val channelId: String,
    val title: String,
    val description: String,
    val thumbnails: Thumbnail,
    val channelTitle: String,
    val localized: Localized
)