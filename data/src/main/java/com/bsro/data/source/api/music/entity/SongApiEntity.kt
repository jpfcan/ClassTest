package com.bsro.data.source.api.music.entity

import com.bsro.domain.music.model.Song

data class SongApiEntity(
    val id: String,
    val name: String,
    val artist: String,
    val genre: String,
    val rating: Int
)


fun SongApiEntity.mapToDomain() =
    Song(id, name, artist, genre)

fun List<SongApiEntity>.mapToDomain() = map { it.mapToDomain() }