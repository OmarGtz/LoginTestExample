package com.omargtz.logintestexample.authentication.di

import com.omargtz.logintestexample.authentication.data.datasource.AuthRemoteDataSource
import com.omargtz.logintestexample.authentication.data.datasource.AuthRemoteDataSourceImp
import com.omargtz.logintestexample.authentication.data.repository.AuthRepository
import com.omargtz.logintestexample.authentication.data.repository.AuthRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
abstract class LoginModule {

    @Singleton
    @Binds
    abstract fun bindsRepository(impl: AuthRepositoryImp): AuthRepository

    @Binds
    abstract fun bindsDataSource(impl: AuthRemoteDataSourceImp): AuthRemoteDataSource

}