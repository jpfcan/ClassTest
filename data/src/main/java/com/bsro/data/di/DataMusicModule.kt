package com.bsro.data.di

import com.bsro.data.repository.MusicRepositoryImpl
import com.bsro.data.source.api.music.client.MusicApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceApiModule::class])
class DataMusicModule {

    @Singleton
    @Provides
    internal fun provideMusicRepository(
        musicApiClient: MusicApiClient
    ) = MusicRepositoryImpl(musicApiClient)

}