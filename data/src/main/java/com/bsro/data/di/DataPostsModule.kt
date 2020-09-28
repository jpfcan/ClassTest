package com.bsro.data.di

import com.bsro.data.repository.posts.PostsRepositoryImpl
import com.bsro.data.source.api.posts.client.PostsApiClient
import com.bsro.domain.posts.repository.PostsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceApiModule::class])
class DataPostsModule {

    @Singleton
    @Provides
    internal fun providePostsRepository(
        postsApiClient: PostsApiClient
    ): PostsRepository = PostsRepositoryImpl(postsApiClient)

}