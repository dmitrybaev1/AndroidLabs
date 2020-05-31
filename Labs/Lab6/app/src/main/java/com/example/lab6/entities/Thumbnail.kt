package com.example.lab6.entities

data class Thumbnail(
    val default: ThumbnailParam,
    val medium: ThumbnailParam,
    val high: ThumbnailParam,
    val standard: ThumbnailParam?,
    val maxres: ThumbnailParam?
)