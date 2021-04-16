package com.omargtz.logintestexample.authentication.data.datasource

import com.omargtz.logintestexample.authentication.data.api.AuthenticationApiService
import com.omargtz.logintestexample.authentication.data.model.CredentialsUser
import com.omargtz.logintestexample.authentication.data.model.DriverDTO
import javax.inject.Inject

class AuthRemoteDataSourceImp @Inject constructor(private val authApiService: AuthenticationApiService) :
    AuthRemoteDataSource {

    override suspend fun login(credential: CredentialsUser): DriverDTO {
        val params: HashMap<String, String> = hashMapOf()
        params["email_phone"] = credential.username
        params["password"] = credential.password
        return authApiService.doLoginDriverUser(params)
    }
}
