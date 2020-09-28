package com.bsro.data.di

import com.bsro.data.source.api.music.client.MusicApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceApiModule {

    @Singleton
    @Provides
    internal fun provideMusicApiClient() = MusicApiClient()

}