package com.example.kursach_app.data.network

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.profile.ProfileResponse
import com.example.kursach_app.data.models.profile.SubscribesResponse
import com.example.kursach_app.data.models.videos.VideoPreview
import retrofit2.Response
import retrofit2.http.GET

interface ProfileService {

    @GET("profile")
    suspend fun getProfileInfo(): Response<ResponseBody<ProfileResponse>>

    @GET("my-subscribes")
    suspend fun getMySubscribes():Response<ResponseBody<List<SubscribesResponse>>>

}