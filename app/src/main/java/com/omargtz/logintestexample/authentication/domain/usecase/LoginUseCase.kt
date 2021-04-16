package com.omargtz.logintestexample.authentication.domain.usecase
import com.omargtz.logintestexample.authentication.data.model.CredentialsUser
import com.omargtz.logintestexample.authentication.data.model.DriverDTO
import com.omargtz.logintestexample.authentication.data.repository.AuthRepository
import com.omargtz.logintestexample.authentication.domain.entity.driver.Driver
import com.omargtz.logintestexample.base.FlowUseCase
import com.omargtz.logintestexample.base.LoginResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) : FlowUseCase<CredentialsUser, Driver>(Dispatchers.IO) {
    override fun execute(parameters: CredentialsUser): Flow<LoginResult<Driver>> {
        return authRepository.login(parameters).map {
            when (it) {
            is LoginResult.Success<DriverDTO> -> {
                with(it.data) {
                    LoginResult.Success(Driver())
                }
            }
                is LoginResult.Error -> {
                 LoginResult.Error(it.exception)
                }
                LoginResult.Loading -> LoginResult.Loading
            }
        }
    }
}
