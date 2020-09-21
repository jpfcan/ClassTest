package com.bsro.domain.music.model

data class Song(
    val id: String,
    val name: String,
    val artist: String,
    val genre: String,
    val rating: Int
)