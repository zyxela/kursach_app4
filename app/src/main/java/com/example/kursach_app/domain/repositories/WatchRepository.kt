package com.example.kursach_app.domain.repositories

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.videos.VideoInfoResponse
import com.example.kursach_app.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface WatchRepository {
   fun getVideoInfo(videoId:String): Flow<ApiResponse<ResponseBody<VideoInfoResponse>>>
}