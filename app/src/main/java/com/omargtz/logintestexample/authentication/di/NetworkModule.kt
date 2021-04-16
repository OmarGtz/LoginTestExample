package com.omargtz.logintestexample.authentication.di

import com.google.gson.GsonBuilder
import com.omargtz.logintestexample.authentication.data.api.AuthenticationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideAuthClient(interceptor: HttpLoggingInterceptor): OkHttpClient  {
        val client = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
        return client.build()
    }

    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.NONE
        return  interceptor
    }

    @Provides
    @Singleton
    fun provideAuthApiService(client: OkHttpClient): AuthenticationApiService {
        val service = Retrofit.Builder()
            .baseUrl("https://apidriver-dev.urbvan.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
        return service.build().create(AuthenticationApiService::class.java)
    }


}