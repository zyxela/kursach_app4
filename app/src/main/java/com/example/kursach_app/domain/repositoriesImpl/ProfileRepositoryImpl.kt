package com.example.kursach_app.domain.repositoriesImpl

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.profile.ProfileResponse
import com.example.kursach_app.data.models.profile.SubscribesResponse
import com.example.kursach_app.data.network.HomePageService
import com.example.kursach_app.data.network.ProfileService
import com.example.kursach_app.domain.repositories.ProfileRepository
import com.example.kursach_app.utils.ApiRequestFlow
import com.example.kursach_app.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val apiRequestFlow: ApiRequestFlow,
    private val profileService: ProfileService
) : ProfileRepository {
    override fun getProfileInfo(): Flow<ApiResponse<ResponseBody<ProfileResponse>>> =
        apiRequestFlow {
            profileService.getProfileInfo()
        }

    override fun getMySubscribes(): Flow<ApiResponse<ResponseBody<List<SubscribesResponse>>>> =
        apiRequestFlow {
            profileService.getMySubscribes()
        }


}