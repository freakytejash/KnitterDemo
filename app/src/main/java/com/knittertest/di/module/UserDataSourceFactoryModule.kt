package com.knittertest.di.module

import com.knittertest.data.local.dao.UserDao
import com.knittertest.data.remote.ApiService
import com.knittertest.factory.UserDataSourceFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

@Module
class UserDataSourceFactoryModule {

    @Provides
    fun provideUserDataSourceFactory(
        userDao: UserDao,
        scope: CoroutineScope,
        apiService: ApiService
    ) = UserDataSourceFactory(
        userDao,
        scope,
        apiService
    )
}