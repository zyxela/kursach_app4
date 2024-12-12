package com.example.kursach_app.di.modules

import com.example.kursach_app.domain.repositories.AuthRepository
import com.example.kursach_app.domain.repositories.ChannelRepository
import com.example.kursach_app.domain.repositories.HomePageRepository
import com.example.kursach_app.domain.repositories.ProfileRepository
import com.example.kursach_app.domain.repositories.WatchRepository
import com.example.kursach_app.domain.repositoriesImpl.AuthRepositoryImpl
import com.example.kursach_app.domain.repositoriesImpl.ChannelRepositoryImpl
import com.example.kursach_app.domain.repositoriesImpl.HomePageRepositoryImpl
import com.example.kursach_app.domain.repositoriesImpl.ProfileRepositoryImpl
import com.example.kursach_app.domain.repositoriesImpl.WatchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    @ViewModelScoped
    fun getHomePageRepository(repository: HomePageRepositoryImpl): HomePageRepository

    @Binds
    @ViewModelScoped
    fun getAuthRepository(repository: AuthRepositoryImpl): AuthRepository

    @Binds
    @ViewModelScoped
    fun getProfileRepository(repository: ProfileRepositoryImpl): ProfileRepository

    @Binds
    @ViewModelScoped
    fun getChannelRepository(repository: ChannelRepositoryImpl): ChannelRepository

    @Binds
    @ViewModelScoped
    fun getWatchRepository(repository: WatchRepositoryImpl): WatchRepository


}