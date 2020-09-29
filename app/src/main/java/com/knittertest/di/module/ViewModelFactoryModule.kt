package com.knittertest.di.module

import androidx.lifecycle.ViewModelProvider
import com.knittertest.factory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}