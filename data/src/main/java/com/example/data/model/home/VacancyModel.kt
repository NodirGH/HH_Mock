package com.example.data.model.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VacancyModel(
    val id: String = "",
    val lookingNumber: Int = 0,
    val title: String = "",
    val town: String = "",
    val street: String = "",
    val house: String = "",
    val company: String = "",
    val experiencePreviewText: String = "",
    val experienceText: String = "",
    val publishedDate: String = "",
    var isFavorite: Boolean = false,
    val fullSalary: String = "",
    val shortSalary: String = "",
    val schedules: List<String> = emptyList(),
    val appliedNumber: Int = 0,
    val description: String = "",
    val responsibilities: String = "",
    val questions: List<String> = emptyList()
): Parcelable
