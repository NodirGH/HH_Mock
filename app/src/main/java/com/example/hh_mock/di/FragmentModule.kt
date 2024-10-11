package com.example.hh_mock.di

import com.example.hh_mock.ui.adapter_delegate.adapters.HeaderAdapter
import com.example.hh_mock.ui.adapter_delegate.adapters.MainAdapter
import com.example.hh_mock.ui.adapter_delegate.adapters.VacanciesAdapter
import com.example.hh_mock.ui.detailed_vacancy.adapter.QuestionsAdapter
import com.example.hh_mock.ui.home.HomeFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    fun provideVacanciesAdapter() = VacanciesAdapter()

    @Provides
    fun provideQuestionsAdapter() = QuestionsAdapter()

    @Provides
    fun provideHeaderAdapter() = HeaderAdapter()
}