package com.bsro.data.repository.posts

import com.bsro.data.source.api.posts.client.PostsApiClient
import com.bsro.data.source.api.posts.entity.mapToDomain
import com.bsro.domain.posts.model.Post
import com.bsro.domain.posts.repository.PostsRepository
import io.reactivex.rxjava3.core.Single

class PostsRepositoryImpl(private val postsApiClient: PostsApiClient): PostsRepository {

    override fun getAllPosts(): Single<List<Post>>  =
        postsApiClient.getPosts()
            .map { it.mapToDomain() }

}