package com.example.kursach_app.domain.repositories

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.home.HomePageResponse
import com.example.kursach_app.data.models.videos.VideoPreview
import com.example.kursach_app.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface HomePageRepository {
    fun getPreviewVideos(): Flow<ApiResponse<ResponseBody<List<VideoPreview>>>>

}