package com.bsro.androidtestapp.di

import android.app.Application
import com.bsro.androidtestapp.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelFactoryProvidersModule::class,
        ActivityBuildersModule::class
    ]
)
interface AppComponent : AndroidInjector<TestApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

}