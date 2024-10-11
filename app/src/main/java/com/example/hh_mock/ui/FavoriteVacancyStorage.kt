package com.example.hh_mock.ui

import android.content.Context
import com.example.data.model.home.VacancyModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FavoriteVacancyStorage(context: Context) {

    private val preferences =
        context.getSharedPreferences("vacancy_preferences", Context.MODE_PRIVATE)
    private val gson = Gson()

    companion object {
        private const val KEY_VACANCY_LIST = "vacancy_list"
    }

    private fun saveVacancies(vacancies: List<VacancyModel>) {
        val jsonString = gson.toJson(vacancies)
        preferences.edit().putString(KEY_VACANCY_LIST, jsonString).apply()
    }

    private fun getVacancies(): List<VacancyModel> {
        val jsonString = preferences.getString(KEY_VACANCY_LIST, null)
        if (jsonString != null) {
            val type = object : TypeToken<List<VacancyModel>>() {}.type
            return gson.fromJson(jsonString, type)
        }
        return emptyList()
    }

    private fun isVacancyAdded(vacancyId: String): Boolean {
        val currentList = getVacancies()
        return currentList.any { it.id == vacancyId }
    }

    fun addVacancy(vacancy: VacancyModel): Boolean {
        val currentList = getVacancies().toMutableList()

        if (!isVacancyAdded(vacancy.id)) {
            currentList.add(vacancy)
            saveVacancies(currentList)
            return true
        }
        return false
    }

    fun clearAll(){
        val currentList = getVacancies().toMutableList()
        currentList.clear()
    }
}



