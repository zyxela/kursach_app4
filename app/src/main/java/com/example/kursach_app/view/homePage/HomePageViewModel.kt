package com.example.kursach_app.view.homePage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.videos.VideoPreview
import com.example.kursach_app.domain.repositories.HomePageRepository
import com.example.kursach_app.utils.ApiResponse
import com.example.kursach_app.utils.baseRequest.BaseRequest
import com.example.kursach_app.utils.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val baseRequest: BaseRequest,
    private val homePageRepository: HomePageRepository
) : ViewModel() {


    private val _homePage =
        MutableStateFlow<ApiResponse<ResponseBody<List<VideoPreview>>>>(ApiResponse.Loading)

    private val _coroutinesErrorHandlerLiveData = MutableLiveData<String>()
    val homePage = _homePage.asStateFlow()
    private val coroutinesErrorHandler = object : CoroutinesErrorHandler {
        override fun onError(message: String) {
            _coroutinesErrorHandlerLiveData.value = message
        }
    }

    fun getVideos() {
        baseRequest(
            _homePage,
            coroutinesErrorHandler,
            viewModelScope
        ) {
            homePageRepository.getPreviewVideos()
        }
    }

}