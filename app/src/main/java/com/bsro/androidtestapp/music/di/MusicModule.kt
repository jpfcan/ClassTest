package com.bsro.androidtestapp.music.di

import com.bsro.data.repository.MusicRepositoryImpl
import com.bsro.domain.music.usecase.GetSongsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MusicModule {

    @Singleton
    @Provides
    internal fun provideGetSongsUseCase(
        musicRepositoryImpl: MusicRepositoryImpl
    ) = GetSongsUseCase(musicRepositoryImpl)

}