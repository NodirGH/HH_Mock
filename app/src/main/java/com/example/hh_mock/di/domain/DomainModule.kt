package com.example.hh_mock.di.domain

import com.example.data.repositories.HomeRepository
import com.example.hh_mock.ui.auth.AuthUseCase
import com.example.hh_mock.ui.auth.AuthUseCaseImpl
import com.example.hh_mock.ui.home.HomeUseCase
import com.example.hh_mock.ui.home.HomeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideHomeUseCase(
        homeRepository: HomeRepository
    ): HomeUseCase{
        return HomeUseCaseImpl(homeRepository)
    }

    @Provides
    fun provideAuthUseCase(
        homeRepository: HomeRepository
    ): AuthUseCase {
        return AuthUseCaseImpl(homeRepository)
    }
}