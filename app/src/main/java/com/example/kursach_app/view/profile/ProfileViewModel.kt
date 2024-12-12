package com.example.kursach_app.view.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.auth.AuthResponse
import com.example.kursach_app.data.models.profile.ProfileResponse
import com.example.kursach_app.data.source.TokenDataSource
import com.example.kursach_app.domain.repositories.ProfileRepository
import com.example.kursach_app.utils.ApiResponse
import com.example.kursach_app.utils.baseRequest.BaseRequest
import com.example.kursach_app.utils.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val baseRequest: BaseRequest,
    private val repository: ProfileRepository,
) : ViewModel() {

    private val _profileInfo = MutableStateFlow<ApiResponse<ResponseBody<ProfileResponse>>>(ApiResponse.Loading)
    val profileInfo = _profileInfo.asStateFlow()

    private val _coroutinesErrorHandlerLiveData = MutableLiveData<String>()
    private val coroutinesErrorHandler = object : CoroutinesErrorHandler {
        override fun onError(message: String) {
            _coroutinesErrorHandlerLiveData.value = message
        }
    }

    fun getProfile(){
        baseRequest(
            _profileInfo,
            coroutinesErrorHandler,
            viewModelScope
        ){
            repository.getProfileInfo()
        }
    }

}