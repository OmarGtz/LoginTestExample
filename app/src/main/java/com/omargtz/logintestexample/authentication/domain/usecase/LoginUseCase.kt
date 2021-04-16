package com.omargtz.logintestexample.authentication.domain.usecase
import com.omargtz.logintestexample.authentication.data.model.DriverDTO
import com.omargtz.logintestexample.authentication.data.repository.AuthRepository
import com.omargtz.logintestexample.authentication.domain.DriverToDomain
import com.omargtz.logintestexample.authentication.domain.entity.driver.Driver
import com.omargtz.logintestexample.authentication.domain.entity.driver.InvalidPassword
import com.omargtz.logintestexample.authentication.domain.entity.driver.User
import com.omargtz.logintestexample.base.FlowUseCase
import com.omargtz.logintestexample.base.LoginResult
import com.omargtz.logintestexample.base.LoginResult.Error
import com.omargtz.logintestexample.base.LoginResult.Loading
import com.omargtz.logintestexample.base.LoginResult.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) : FlowUseCase<User, Driver>(Dispatchers.IO) {
    override fun execute(parameters: User): Flow<LoginResult<Driver>> {

        if (parameters.emailIsValid() && parameters.passwordIsValid()) {
            return authenticate(user = parameters)
        }

        return flow<LoginResult<Driver>> {
            if (!parameters.emailIsValid())  {
                emit(Error(InvalidPassword()))
            } else if (!parameters.passwordIsValid()) {
                emit(Error(InvalidPassword()))
            } else {
                emit(Error(UnknownError()))
            }
        }
    }

    private fun authenticate(user: User): Flow<LoginResult<Driver>> {
        return authRepository.login(user).map {
            when (it) {
                is Success<DriverDTO> -> {
                    with(it.data) {
                        val driver = DriverToDomain.map(this)
                        if (driver.isActive()) {
                            Success(driver)
                        } else {
                            error(UnknownError())
                        }
                    }
                }
                is Error -> {
                    Error(it.exception)
                }
                Loading -> Loading
            }
        }
    }
}
