package com.omargtz.logintestexample.authentication.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omargtz.logintestexample.authentication.domain.entity.driver.Driver
import com.omargtz.logintestexample.authentication.domain.entity.driver.User
import com.omargtz.logintestexample.authentication.domain.usecase.LoginUseCase
import com.omargtz.logintestexample.base.LoginResult

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _driver: MutableLiveData<LoginResult<Driver>> = MutableLiveData()
    val driver: LiveData<LoginResult<Driver>> get() =  _driver

    /**request login user*/
    fun login(user: String, password: String) {
        viewModelScope.launch {
            loginUseCase.invoke(
                User(user, password)
            ).collect {
                    _driver.value = it
            }
        }
    }
}
