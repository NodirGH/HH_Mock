package com.example.data.remote.responses

import com.example.data.model.home.OfferResponse

data class HHMockDataResponse(
    val offers: List<OfferResponse>,
    val vacancies: List<VacancyResponse>
)
