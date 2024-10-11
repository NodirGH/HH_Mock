package com.example.data.di

import android.content.Context
import com.example.data.local.AppPreferences
import com.example.data.remote.service.HomeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideAppPreference(@ApplicationContext applicationContext: Context): AppPreferences{
        return AppPreferences(applicationContext)
    }

    @Singleton
    @Provides
    fun provideHomeService(@ApplicationContext applicationContext: Context) : HomeService{
        return HomeService(applicationContext)
    }
}