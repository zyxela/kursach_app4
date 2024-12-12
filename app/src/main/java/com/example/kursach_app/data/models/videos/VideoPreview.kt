package com.example.kursach_app.data.models.videos

data class VideoPreview(
    val id: String,
    val title: String,
    val previewUrl: String,
    val channelId: String,
    val channelImageUrl: String,
    val channelName: String,
)