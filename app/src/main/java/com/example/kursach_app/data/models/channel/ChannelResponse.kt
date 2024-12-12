package com.example.kursach_app.data.models.channel

data class ChannelResponse(
    val userDTO: UserDTO,
    val videos: List<Video>
)