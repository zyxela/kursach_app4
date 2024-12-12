package com.example.kursach_app.view.watch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.auth.AuthResponse
import com.example.kursach_app.data.models.videos.VideoInfoResponse
import com.example.kursach_app.domain.repositories.WatchRepository
import com.example.kursach_app.utils.ApiResponse
import com.example.kursach_app.utils.baseRequest.BaseRequest
import com.example.kursach_app.utils.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class WatchViewModel @Inject constructor(
    private val baseRequest: BaseRequest,
    private val watchRepository: WatchRepository
) : ViewModel() {

    private val _info =
        MutableStateFlow<ApiResponse<ResponseBody<VideoInfoResponse>>>(ApiResponse.Loading)
    val info = _info.asStateFlow()

    private val _coroutinesErrorHandlerLiveData = MutableLiveData<String>()
    private val coroutinesErrorHandler = object : CoroutinesErrorHandler {
        override fun onError(message: String) {
            _coroutinesErrorHandlerLiveData.value = message
        }
    }

    fun getVideoInfo(videoId:String){
        baseRequest(
            _info,
            coroutinesErrorHandler,
            viewModelScope
        ){
            watchRepository.getVideoInfo(videoId)
        }
    }
}