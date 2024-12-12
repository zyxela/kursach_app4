package com.example.kursach_app.data.network

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.channel.ChannelResponse
import com.example.kursach_app.data.models.videos.VideoInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WatchService {

    @GET("videoInfo/{videoId}")
    suspend fun getVideoInfo(@Path("videoId") videoId:String): Response<ResponseBody<VideoInfoResponse>>


}