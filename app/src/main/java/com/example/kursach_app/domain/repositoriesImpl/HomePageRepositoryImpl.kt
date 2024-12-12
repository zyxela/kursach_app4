package com.example.kursach_app.domain.repositoriesImpl

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.home.HomePageResponse
import com.example.kursach_app.data.models.videos.VideoPreview
import com.example.kursach_app.data.network.HomePageService
import com.example.kursach_app.domain.repositories.HomePageRepository
import com.example.kursach_app.utils.ApiRequestFlow
import com.example.kursach_app.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomePageRepositoryImpl @Inject constructor(
    private val apiRequestFlow: ApiRequestFlow,
    private val homePageService: HomePageService
) : HomePageRepository {
    override fun getPreviewVideos(): Flow<ApiResponse<ResponseBody<List<VideoPreview>>>> =
        apiRequestFlow {
            homePageService.getHomePage()
        }

}