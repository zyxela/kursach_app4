package com.example.kursach_app.domain.repositories

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.auth.AuthResponse
import com.example.kursach_app.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(email:String, password:String): Flow<ApiResponse<ResponseBody<AuthResponse>>>
    fun register(name:String, email:String, password:String): Flow<ApiResponse<ResponseBody<AuthResponse>>>
}