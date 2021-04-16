package com.omargtz.logintestexample.authentication.data.repository

import com.omargtz.logintestexample.authentication.data.model.DriverDTO
import com.omargtz.logintestexample.authentication.domain.entity.driver.User
import com.omargtz.logintestexample.base.LoginResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(credential: User): Flow<LoginResult<DriverDTO>>
}

