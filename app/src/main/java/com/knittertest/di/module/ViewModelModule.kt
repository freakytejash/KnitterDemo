package com.knittertest.di.module

import androidx.lifecycle.ViewModel
import com.knittertest.ui.main.MainViewModel
import com.knittertest.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}