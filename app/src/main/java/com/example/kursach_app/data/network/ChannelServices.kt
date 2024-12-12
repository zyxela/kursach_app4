package com.example.kursach_app.data.network

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.channel.ChannelResponse
import com.example.kursach_app.data.models.channel.SubscribeRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ChannelServices {

    @GET("channel/{channelId}")
    suspend fun getChannelInfo(@Path("channelId") channelId: String): Response<ResponseBody<ChannelResponse>>

    @POST("subscribe")
    suspend fun subscribe(@Body subscribeRequest: SubscribeRequest): Response<ResponseBody<Boolean>>
}