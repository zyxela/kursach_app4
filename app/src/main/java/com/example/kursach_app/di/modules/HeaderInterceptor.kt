package com.example.kursach_app.di.modules

import com.example.kursach_app.data.source.TokenDataSource
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val prefs: TokenDataSource
) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken = runBlocking {
            prefs.getAccessToken()
        }
        val request = chain.request().newBuilder()
        request.addHeader("Authorization", "Bearer $accessToken")
        return chain.proceed(request.build())
    }
}