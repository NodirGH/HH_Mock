package com.example.data.model.home

import com.example.data.local.DisplayableItem

data class AllVacancyModel(
    val vacancies: List<VacancyModel>
): DisplayableItem
