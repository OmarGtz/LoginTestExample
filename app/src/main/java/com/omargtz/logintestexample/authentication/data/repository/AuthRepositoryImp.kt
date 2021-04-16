package com.omargtz.logintestexample.authentication.data.repository

import com.omargtz.logintestexample.authentication.data.datasource.AuthRemoteDataSource
import com.omargtz.logintestexample.authentication.data.model.DriverDTO
import com.omargtz.logintestexample.authentication.domain.entity.driver.User
import com.omargtz.logintestexample.base.LoginResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(
    private val authApidataSource: AuthRemoteDataSource
) : AuthRepository {
    override fun login(credential: User): Flow<LoginResult<DriverDTO>> {
        return flow {
            emit(LoginResult.Loading)
            try {
                val loginResponse = authApidataSource.login(credential)
                emit(LoginResult.Success(loginResponse))
            } catch (e: Throwable) {
                emit(LoginResult.Error(e))
            }
        }
    }
}
