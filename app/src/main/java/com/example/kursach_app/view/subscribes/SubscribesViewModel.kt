package com.example.kursach_app.view.subscribes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.profile.SubscribesResponse
import com.example.kursach_app.domain.repositories.ProfileRepository
import com.example.kursach_app.utils.ApiResponse
import com.example.kursach_app.utils.baseRequest.BaseRequest
import com.example.kursach_app.utils.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class SubscribesViewModel @Inject constructor(
    private val baseRequest: BaseRequest,
    private val subscribesRepository: ProfileRepository
):ViewModel() {

    private val _subscribes =
        MutableStateFlow<ApiResponse<ResponseBody<List<SubscribesResponse>>>>(ApiResponse.Loading)
    val subscribes = _subscribes.asStateFlow()
    private val _coroutinesErrorHandlerLiveData = MutableLiveData<String>()
    private val coroutinesErrorHandler = object : CoroutinesErrorHandler {
        override fun onError(message: String) {
            _coroutinesErrorHandlerLiveData.value = message
        }
    }

    fun getMySubscribes(){
        baseRequest(_subscribes, coroutinesErrorHandler, viewModelScope){
            subscribesRepository.getMySubscribes()
        }
    }



}