package com.bsro.data.source.api.posts.entity

import com.bsro.domain.posts.model.Post
import com.google.gson.annotations.SerializedName

data class PostApiEntity(
    val id: Int,
    val userId: Int?,
    val title: String?,
    @SerializedName("body") val content: String?
)

fun PostApiEntity.mapToDomain() =
    Post(
        id,
        title ?: "",
        content ?: ""
    )

fun List<PostApiEntity>.mapToDomain() = this.map { it.mapToDomain() }