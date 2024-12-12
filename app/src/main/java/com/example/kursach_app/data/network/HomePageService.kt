package com.example.kursach_app.data.network

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.home.HomePageResponse
import com.example.kursach_app.data.models.videos.VideoPreview
import retrofit2.Response
import retrofit2.http.GET

interface HomePageService {
    @GET("home")
    suspend fun getHomePage(): Response<ResponseBody<List<VideoPreview>>>
}