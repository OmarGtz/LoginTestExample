package com.omargtz.logintestexample.authentication.data.datasource
import com.omargtz.logintestexample.authentication.data.model.DriverDTO
import com.omargtz.logintestexample.authentication.domain.entity.driver.User

interface AuthRemoteDataSource {
    suspend fun login(credential: User): DriverDTO
}
