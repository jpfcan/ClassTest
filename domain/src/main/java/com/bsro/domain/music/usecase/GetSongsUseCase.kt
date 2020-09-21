package com.bsro.domain.music.usecase

import com.bsro.domain.music.repository.MusicRepository
import io.reactivex.rxjava3.schedulers.Schedulers

class GetSongsUseCase(private val musicRepository: MusicRepository) {

    fun execute() =
        musicRepository.getSongs()
            .subscribeOn(Schedulers.io())

}