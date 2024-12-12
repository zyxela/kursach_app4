package com.example.kursach_app.data.models.auth

data class RegistrationRequest(
    val username:String,
    val email:String,
    val password:String
)