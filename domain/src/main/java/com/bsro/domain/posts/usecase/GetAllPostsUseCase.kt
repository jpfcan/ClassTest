package com.bsro.domain.posts.usecase

import com.bsro.domain.posts.model.Post
import com.bsro.domain.posts.repository.PostsRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetAllPostsUseCase(private val postsRepository: PostsRepository) {

    fun execute(): Single<List<Post>> =
        postsRepository.getAllPosts()
            .subscribeOn(Schedulers.io())

}