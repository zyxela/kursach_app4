package com.example.kursach_app.domain.repositoriesImpl

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.auth.AuthRequest
import com.example.kursach_app.data.models.auth.AuthResponse
import com.example.kursach_app.data.models.auth.RegistrationRequest
import com.example.kursach_app.data.network.AuthService
import com.example.kursach_app.domain.repositories.AuthRepository
import com.example.kursach_app.utils.ApiRequestFlow
import com.example.kursach_app.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiRequestFlow: ApiRequestFlow,
    private val authService: AuthService
) : AuthRepository {
    override fun login(
        email: String,
        password: String
    ): Flow<ApiResponse<ResponseBody<AuthResponse>>> =
        apiRequestFlow {
            authService.authorization(AuthRequest(email, password))
        }

    override fun register(
        name: String,
        email: String,
        password: String
    ): Flow<ApiResponse<ResponseBody<AuthResponse>>> =
        apiRequestFlow {
            authService.registration(RegistrationRequest(name, email, password))
        }


}