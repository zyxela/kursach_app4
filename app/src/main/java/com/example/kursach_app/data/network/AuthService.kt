package com.example.kursach_app.data.network

import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.auth.AuthRequest
import com.example.kursach_app.data.models.auth.AuthResponse
import com.example.kursach_app.data.models.auth.RegistrationRequest

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("login")
    suspend fun authorization(@Body authRequest: AuthRequest): Response<ResponseBody<AuthResponse>>

    @POST("registration")
    suspend fun registration(@Body regRequest: RegistrationRequest): Response<ResponseBody<AuthResponse>>


}