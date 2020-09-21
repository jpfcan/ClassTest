package com.bsro.data.source.api.music.client

import com.bsro.data.source.api.music.entity.SongApiEntity
import io.reactivex.rxjava3.core.Single

class MusicApiClient {

    fun getSongs(): Single<List<SongApiEntity>> =
        Single.create<List<SongApiEntity>> {
            it.onSuccess(
                listOf(
                    SongApiEntity("2", "Title1", "artist1", "genre1", 3),
                    SongApiEntity("2", "Title2", "artist2", "genre1", 3),
                    SongApiEntity("2", "Title3", "artist3", "genre1", 2),
                    SongApiEntity("2", "Title4", "artist4", "genre1", 5),
                    SongApiEntity("2", "Title5", "artist5", "genre1", 1)
                )
            )
        }

}