package com.knittertest

import android.app.Application
import com.knittertest.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class KnitterApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().create(this).build().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}