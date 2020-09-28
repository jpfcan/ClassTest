package com.bsro.androidtestapp.music.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bsro.androidtestapp.BaseViewModel
import com.bsro.domain.music.model.Song
import com.bsro.domain.music.usecase.GetSongsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class SongsViewModel
@Inject constructor(
    getSongsUseCase: GetSongsUseCase
) : BaseViewModel() {

    private val songsLiveData = MutableLiveData<List<Song>>()
    private val songsErrorLiveData = MutableLiveData<Unit>()

    init {
        compositeDisposable.add(
            getSongsUseCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Song>>() {
                    override fun onSuccess(t: List<Song>) {
                        songsLiveData.value = t
                    }

                    override fun onError(e: Throwable?) {
                        songsErrorLiveData.value = Unit
                    }
                })
        )
    }

    fun getSongsLiveData(): LiveData<List<Song>> = songsLiveData

}