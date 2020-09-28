package com.bsro.data.di

import com.bsro.data.repository.music.MusicRepositoryImpl
import com.bsro.data.source.api.music.client.MusicApiClient
import com.bsro.domain.music.repository.MusicRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceApiModule::class])
class DataMusicModule {

    @Singleton
    @Provides
    internal fun provideMusicRepository(
        musicApiClient: MusicApiClient
    ): MusicRepository = MusicRepositoryImpl(musicApiClient)

}