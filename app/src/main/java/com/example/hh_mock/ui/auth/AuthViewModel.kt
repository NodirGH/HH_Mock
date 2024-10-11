package com.example.hh_mock.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> = _isLogin

    fun login(code: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = authUseCase.login(code)
            _isLogin.postValue(result)
        }
    }
}