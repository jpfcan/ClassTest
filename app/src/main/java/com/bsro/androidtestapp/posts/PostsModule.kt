package com.bsro.androidtestapp.posts

import com.bsro.data.repository.posts.PostsRepositoryImpl
import com.bsro.domain.posts.usecase.GetAllPostsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PostsModule {

    @Singleton
    @Provides
    internal fun provideGetPostsUseCase(
        postsRepositoryImpl: PostsRepositoryImpl
    ) = GetAllPostsUseCase(postsRepositoryImpl)

}