package com.bsro.data.di

import com.bsro.data.source.api.music.client.MusicApiClient
import com.bsro.data.source.api.posts.client.PostApiService
import com.bsro.data.source.api.posts.client.PostsApiClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataSourceApiModule {

    @Singleton
    @Provides
    internal fun provideRetrofit() =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Singleton
    @Provides
    internal fun provideMusicApiClient() = MusicApiClient()

    @Singleton
    @Provides
    internal fun providePostsApiClient(retrofit: Retrofit) =
        PostsApiClient(retrofit.create(PostApiService::class.java))

}