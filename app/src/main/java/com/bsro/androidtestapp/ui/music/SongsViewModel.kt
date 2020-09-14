package com.bsro.androidtestapp.ui.music

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bsro.androidtestapp.data.Song

class SongsViewModel: ViewModel() {

    private val songsLiveData = MutableLiveData<List<Song>>()

    init {
        songsLiveData.value = listOf(
            Song("2", "Title1", "artist1", "genre1", 3),
            Song("2", "Title2", "artist2", "genre1", 3),
            Song("2", "Title3", "artist3", "genre1", 2),
            Song("2", "Title4", "artist4", "genre1", 5),
            Song("2", "Title5", "artist5", "genre1", 1)
        )
    }

    fun getSongsLiveData(): LiveData<List<Song>> = songsLiveData

}