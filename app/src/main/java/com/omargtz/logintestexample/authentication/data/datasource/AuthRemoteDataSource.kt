package com.omargtz.logintestexample.authentication.data.datasource
import com.omargtz.logintestexample.authentication.data.model.CredentialsUser
import com.omargtz.logintestexample.authentication.data.model.DriverDTO

interface AuthRemoteDataSource {
    suspend fun login(credential: CredentialsUser): DriverDTO
}
