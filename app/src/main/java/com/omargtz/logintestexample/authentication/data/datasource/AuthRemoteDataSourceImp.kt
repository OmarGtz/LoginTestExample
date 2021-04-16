package com.omargtz.logintestexample.authentication.data.datasource

import com.omargtz.logintestexample.authentication.data.api.AuthenticationApiService
import com.omargtz.logintestexample.authentication.data.model.DriverDTO
import com.omargtz.logintestexample.authentication.domain.entity.driver.User
import javax.inject.Inject

class AuthRemoteDataSourceImp @Inject constructor(private val authApiService: AuthenticationApiService) :
    AuthRemoteDataSource {
    override suspend fun login(credential: User): DriverDTO {
        val params: HashMap<String, String> = hashMapOf()
        params["email_phone"] = credential.email
        params["password"] = credential.password
        return authApiService.doLoginDriverUser(params)
    }
}
