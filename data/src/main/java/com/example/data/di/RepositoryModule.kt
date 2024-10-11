package com.example.data.di

import com.example.data.local.AppPreferences
import com.example.data.remote.service.HomeService
import com.example.data.repositories.HomeRepository
import com.example.data.repositories.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(
        service: HomeService,
        preferences: AppPreferences
    ): HomeRepository {
        return HomeRepositoryImpl(service, preferences)
    }

}