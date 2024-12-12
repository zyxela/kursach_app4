package com.example.kursach_app.di.modules

import com.example.kursach_app.data.network.AuthService
import com.example.kursach_app.data.network.ChannelServices
import com.example.kursach_app.data.network.HomePageService
import com.example.kursach_app.data.network.ProfileService
import com.example.kursach_app.data.network.WatchService
import com.example.kursach_app.data.source.TokenDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    companion object {
        const val BASE_URL = "http:/10.0.2.2:8080/"
    }

    @Provides
    fun getRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    fun getClient(authInterceptor: HeaderInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(authInterceptor)
            .build()
    }

    @Provides
    fun provideAuthInterceptor(tokenManager: TokenDataSource): HeaderInterceptor =
        HeaderInterceptor(tokenManager)


    @Provides
    @Singleton
    fun getHomePageService(retrofit: Builder, okHttpClient: OkHttpClient): HomePageService =
        retrofit.client(okHttpClient).build().create(HomePageService::class.java)

    @Provides
    @Singleton
    fun getAuthService(retrofit: Builder, okHttpClient: OkHttpClient): AuthService =
        retrofit.client(okHttpClient).build().create(AuthService::class.java)


    @Provides
    @Singleton
    fun getProfileService(retrofit: Builder, okHttpClient: OkHttpClient): ProfileService =
        retrofit.client(okHttpClient).build().create(ProfileService::class.java)

    @Provides
    @Singleton
    fun getChannelService(retrofit: Builder, okHttpClient: OkHttpClient): ChannelServices =
        retrofit.client(okHttpClient).build().create(ChannelServices::class.java)

    @Provides
    @Singleton
    fun getWatchService(retrofit: Builder, okHttpClient: OkHttpClient): WatchService =
        retrofit.client(okHttpClient).build().create(WatchService::class.java)
}