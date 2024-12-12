package com.example.kursach_app.domain.repositoriesImpl

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.channel.ChannelResponse
import com.example.kursach_app.data.models.channel.SubscribeRequest
import com.example.kursach_app.data.network.ChannelServices
import com.example.kursach_app.domain.repositories.ChannelRepository
import com.example.kursach_app.utils.ApiRequestFlow
import com.example.kursach_app.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChannelRepositoryImpl @Inject constructor(
    private val apiRequestFlow: ApiRequestFlow,
    private val channelServices: ChannelServices
) : ChannelRepository {

    override fun getChannelInfo(channelId: String): Flow<ApiResponse<ResponseBody<ChannelResponse>>> =
        apiRequestFlow {
            channelServices.getChannelInfo(channelId)
        }

    override fun subscribe(subscribeRequest: SubscribeRequest): Flow<ApiResponse<ResponseBody<Boolean>>> =
        apiRequestFlow {
            channelServices.subscribe(subscribeRequest)
        }


}