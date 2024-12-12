package com.example.kursach_app.view.channel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.channel.ChannelResponse
import com.example.kursach_app.data.models.channel.SubscribeRequest
import com.example.kursach_app.data.models.videos.VideoPreview
import com.example.kursach_app.domain.repositories.ChannelRepository
import com.example.kursach_app.utils.ApiResponse
import com.example.kursach_app.utils.baseRequest.BaseRequest
import com.example.kursach_app.utils.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ChannelViewModel @Inject constructor(
    private val baseRequest: BaseRequest,
    private val channelRepository: ChannelRepository
) : ViewModel() {

    private val _channelResponse =
        MutableStateFlow<ApiResponse<ResponseBody<ChannelResponse>>>(ApiResponse.Loading)
    val channelResponse = _channelResponse.asStateFlow()

    private val _isSubscribed =
        MutableStateFlow<ApiResponse<ResponseBody<Boolean>>>(ApiResponse.Loading)
    val isSubscribed = _isSubscribed.asStateFlow()

    private val _coroutinesErrorHandlerLiveData = MutableLiveData<String>()

    private val coroutinesErrorHandler = object : CoroutinesErrorHandler {
        override fun onError(message: String) {
            _coroutinesErrorHandlerLiveData.value = message
        }
    }

    fun getChannelInfo(channelId: String) {
        baseRequest(_channelResponse, coroutinesErrorHandler, viewModelScope) {
            channelRepository.getChannelInfo(channelId)
        }
    }

    fun subscribe(channelId: String) {
        baseRequest(_isSubscribed, coroutinesErrorHandler, viewModelScope) {
            channelRepository.subscribe(SubscribeRequest(channelId))
        }
    }
}