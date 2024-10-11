package com.example.hh_mock.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.DisplayableItem
import com.example.data.model.home.AllVacancyModel
import com.example.data.model.home.VacancyModel
import com.example.hh_mock.ui.home.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase) : ViewModel() {

    private val _displayableItem = MutableLiveData<List<DisplayableItem>>()
    val displayableItem: LiveData<List<DisplayableItem>> = _displayableItem

    private val _favorites = MutableLiveData<List<VacancyModel>>()
    val favorites: LiveData<List<VacancyModel>> = _favorites

    fun getAllData() {

        viewModelScope.launch(Dispatchers.IO) {
            val allData = homeUseCase.getAllData()
            _displayableItem.postValue(allData)

            val favoriteList: ArrayList<VacancyModel> = ArrayList()

            allData.forEach { displayableItem ->
                if (displayableItem is AllVacancyModel) {
                    displayableItem.vacancies.forEach { vacancy ->
                        if (vacancy.isFavorite) {
                            favoriteList.add(vacancy)
                        }
                    }
                }
            }

            _favorites.postValue(favoriteList)
        }


    }
}