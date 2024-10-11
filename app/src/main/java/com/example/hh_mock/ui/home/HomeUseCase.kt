package com.example.hh_mock.ui.home

import com.example.data.local.DisplayableItem
import com.example.data.model.home.VacancyModel
import com.example.data.repositories.HomeRepository
import javax.inject.Inject

interface HomeUseCase {
    suspend fun getAllData(): ArrayList<DisplayableItem>
}

class HomeUseCaseImpl @Inject constructor(private val homeRepository: HomeRepository) :
    HomeUseCase {

    override suspend fun getAllData():  ArrayList<DisplayableItem>  {
        return homeRepository.getAllData()
    }
}