package com.example.data.repositories

import com.example.data.local.AppPreferences
import com.example.data.local.DisplayableItem
import com.example.data.model.home.*
import com.example.data.remote.service.HomeService
import javax.inject.Inject

interface HomeRepository {
    suspend fun getAllData(): ArrayList<DisplayableItem>
    suspend fun login(code: String): Boolean
}

class HomeRepositoryImpl @Inject constructor(
    private val service: HomeService,
    private val preferences: AppPreferences
) : HomeRepository {

    override suspend fun getAllData(): ArrayList<DisplayableItem>  {
        val allData = service.readMockDataFromAssets()

        val displayableItem = ArrayList<DisplayableItem>()
        val vacancies = allData?.vacancies?.map { vacancy ->
            VacancyModel(
                id = vacancy.id ?: "",
                lookingNumber = vacancy.lookingNumber ?: 0,
                title = vacancy.title ?: "",
                town = vacancy.address.town ?: "",
                street = vacancy.address.street ?: "",
                house = vacancy.address.house ?: "",
                company = vacancy.company ?: "",
                experiencePreviewText = vacancy.experience.previewText ?: "",
                experienceText = vacancy.experience.text ?: "",
                publishedDate = vacancy.publishedDate ?: "",
                isFavorite = vacancy.isFavorite ?: false,
                fullSalary = vacancy.salary.full ?: "",
                shortSalary = vacancy.salary.short ?: "",
                schedules = vacancy.schedules ?: emptyList(),
                description = vacancy.description ?: "",
                responsibilities = vacancy.responsibilities ?: "",
                questions = vacancy.questions ?: emptyList(),
                appliedNumber = vacancy.appliedNumber ?: 0
            )
        }

        val header = allData?.offers?.map { offerResponse ->
            HeadersModel(
                id = offerResponse.id ?: "",
                title = offerResponse.title ?: "",
                link = offerResponse.link ?: "",
                buttonText = offerResponse.button?.text ?: "",
            )
        }

        displayableItem.add(AllHeadersModel(header ?: emptyList()))
        displayableItem.add(AllVacancyModel(vacancies ?: emptyList()))

        return displayableItem
    }

    override suspend fun login(code: String): Boolean {
        preferences.isUserRegister = true
        return true
    }
}