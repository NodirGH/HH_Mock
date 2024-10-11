package com.example.hh_mock.ui.auth

import com.example.data.repositories.HomeRepository
import javax.inject.Inject

interface AuthUseCase {
    suspend fun login(code: String): Boolean
}

class AuthUseCaseImpl @Inject constructor(private val homeRepository: HomeRepository): AuthUseCase{
    override suspend fun login(code: String): Boolean {
        return homeRepository.login(code)
    }
}