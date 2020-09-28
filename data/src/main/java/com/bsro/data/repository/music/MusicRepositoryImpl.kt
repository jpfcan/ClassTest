package com.bsro.data.repository.music

import com.bsro.data.source.api.music.client.MusicApiClient
import com.bsro.data.source.api.music.entity.mapToDomain
import com.bsro.domain.music.model.Song
import com.bsro.domain.music.repository.MusicRepository
import io.reactivex.rxjava3.core.Single

class MusicRepositoryImpl(
    private val musicApiClient: MusicApiClient
): MusicRepository {

    override fun getSongs(): Single<List<Song>> =
        musicApiClient.getSongs()
            .map { it.mapToDomain() }

}