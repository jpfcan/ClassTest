package com.bsro.data.source.api.posts.client

import com.bsro.data.source.api.posts.entity.PostApiEntity
import retrofit2.Call
import retrofit2.http.GET

interface PostApiService {

    @GET("/posts")
    fun getAllPosts(): Call<List<PostApiEntity>>

}