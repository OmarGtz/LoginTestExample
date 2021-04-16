package com.omargtz.logintestexample.authentication.data.repository

import com.omargtz.logintestexample.authentication.data.model.CredentialsUser
import com.omargtz.logintestexample.authentication.data.model.DriverDTO
import com.omargtz.logintestexample.base.LoginResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(credential: CredentialsUser): Flow<LoginResult<DriverDTO>>
}
