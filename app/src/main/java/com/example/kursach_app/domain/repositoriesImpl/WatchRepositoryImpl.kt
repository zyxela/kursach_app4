package com.example.kursach_app.domain.repositoriesImpl

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.videos.VideoInfoResponse
import com.example.kursach_app.data.network.WatchService
import com.example.kursach_app.domain.repositories.WatchRepository
import com.example.kursach_app.utils.ApiRequestFlow
import com.example.kursach_app.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WatchRepositoryImpl @Inject constructor(
    private val apiRequestFlow: ApiRequestFlow,
    private val watchService: WatchService

): WatchRepository {
    override fun getVideoInfo(videoId: String): Flow<ApiResponse<ResponseBody<VideoInfoResponse>>> =
        apiRequestFlow{
            watchService.getVideoInfo(videoId)
        }

}