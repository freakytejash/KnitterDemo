package com.knittertest.di.component

import android.app.Application
import com.knittertest.KnitterApp
import com.knittertest.di.builder.ActivityBuilder
import com.knittertest.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        ViewModelModule::class,
        ViewModelFactoryModule::class,
        ApiModule::class,
        DatabaseModule::class,
        AppModule::class,
        UserDataSourceFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<KnitterApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: KnitterApp)
}