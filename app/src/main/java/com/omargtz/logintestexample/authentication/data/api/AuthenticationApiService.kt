package com.omargtz.logintestexample.authentication.data.api
import com.omargtz.logintestexample.authentication.data.model.DriverDTO
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.HashMap

interface AuthenticationApiService {
    @POST("/fleet/drivers/login/")
    suspend fun doLoginDriverUser(@Body params: HashMap<String, String>): DriverDTO
}
