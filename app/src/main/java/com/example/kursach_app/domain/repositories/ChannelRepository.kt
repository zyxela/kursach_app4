package com.example.kursach_app.domain.repositories

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.channel.ChannelResponse
import com.example.kursach_app.data.models.channel.SubscribeRequest
import com.example.kursach_app.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface ChannelRepository {
    fun getChannelInfo(channelId: String): Flow<ApiResponse<ResponseBody<ChannelResponse>>>

    fun subscribe(subscribeRequest: SubscribeRequest): Flow<ApiResponse<ResponseBody<Boolean>>>
}