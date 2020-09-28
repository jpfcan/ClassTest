package com.bsro.domain.music.repository

import com.bsro.domain.music.model.Song
import io.reactivex.rxjava3.core.Single

interface MusicRepository {

    fun getSongs(): Single<List<Song>>

}