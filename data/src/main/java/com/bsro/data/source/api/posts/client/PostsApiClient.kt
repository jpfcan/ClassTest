package com.bsro.data.source.api.posts.client

import com.bsro.data.source.api.commons.SingleCallback
import com.bsro.data.source.api.posts.entity.PostApiEntity
import io.reactivex.rxjava3.core.Single

class PostsApiClient(private val apiService: PostApiService) {

    fun getPosts(): Single<List<PostApiEntity>> =
        Single.create {
            val call = apiService.getAllPosts()
            val callback = SingleCallback<List<PostApiEntity>>(it)

            call.enqueue(callback)
        }

}