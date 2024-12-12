package com.example.kursach_app.domain.repositories

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.profile.ProfileResponse
import com.example.kursach_app.data.models.profile.SubscribesResponse
import com.example.kursach_app.data.models.videos.VideoPreview
import com.example.kursach_app.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun getProfileInfo(): Flow<ApiResponse<ResponseBody<ProfileResponse>>>
    fun getMySubscribes():Flow<ApiResponse<ResponseBody<List<SubscribesResponse>>>>
}