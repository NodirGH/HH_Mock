package com.example.data.remote.responses


data class VacancyResponse(
    val id: String?,
    val lookingNumber: Int?,
    val title: String?,
    val address: AddressRemoteModel,
    val company: String?,
    val experience: ExperienceRemoteModel,
    val publishedDate: String?,
    var isFavorite: Boolean?,
    val salary: SalaryRemoteModel,
    val schedules: List<String>?,
    val appliedNumber: Int?,
    val description: String?,
    val responsibilities: String?,
    val questions: List<String>?
)

data class AddressRemoteModel(
    val town: String?,
    val street: String?,
    val house: String?
    )

data class ExperienceRemoteModel(
    val previewText: String?,
    val text: String?
    )

data class SalaryRemoteModel(
    val full: String?,
    val short: String?
)
