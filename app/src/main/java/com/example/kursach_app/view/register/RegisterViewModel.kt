package com.example.kursach_app.view.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.auth.AuthResponse
import com.example.kursach_app.data.source.TokenDataSource
import com.example.kursach_app.domain.repositories.AuthRepository
import com.example.kursach_app.utils.ApiResponse
import com.example.kursach_app.utils.baseRequest.BaseRequest
import com.example.kursach_app.utils.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val baseRequest: BaseRequest,
    private val authRepository: AuthRepository,
    private val tokenDataSource: TokenDataSource
):ViewModel(){
    private val _token =
        MutableStateFlow<ApiResponse<ResponseBody<AuthResponse>>>(ApiResponse.Loading)
    val token = _token.asStateFlow()
    private val _coroutinesErrorHandlerLiveData = MutableLiveData<String>()
    private val coroutinesErrorHandler = object : CoroutinesErrorHandler {
        override fun onError(message: String) {
            _coroutinesErrorHandlerLiveData.value = message
        }
    }

    fun login(name:String, login: String, password: String) {
        baseRequest(_token, coroutinesErrorHandler, viewModelScope) {
            authRepository.register(name, login, password)
        }
    }

    fun setToken(token: String) {
        tokenDataSource.setAccessToken(token)
    }
}
