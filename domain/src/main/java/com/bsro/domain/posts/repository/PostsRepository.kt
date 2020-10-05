package com.bsro.domain.posts.repository

import com.bsro.domain.posts.model.Post
import io.reactivex.rxjava3.core.Single

interface PostsRepository {

    fun getAllPosts(): Single<List<Post>>

}