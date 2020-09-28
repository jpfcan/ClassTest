package com.bsro.androidtestapp.di

import android.app.Application
import com.bsro.androidtestapp.TestApplication
import com.bsro.androidtestapp.music.di.MusicModule
import com.bsro.androidtestapp.posts.PostsModule
import com.bsro.data.di.DataMusicModule
import com.bsro.data.di.DataPostsModule
import com.bsro.data.di.DataSourceApiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        FragmentBuildersModule::class,
        TestModule::class,
        MusicModule::class,
        PostsModule::class,
        DataMusicModule::class,
        DataPostsModule::class,
        DataSourceApiModule::class
    ]
)
interface AppComponent : AndroidInjector<TestApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

}