package com.bsro.androidtestapp.ui.music.adapter.items

import com.bsro.androidtestapp.R
import com.bsro.androidtestapp.data.Song
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item_song.view.*

class SongItem(val song: Song): Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            textViewSongTitle.text = song.name
            textViewArtist.text = song.artist
            textViewGenre.text = song.genre
            seekBarRating.progress = song.rating - 1

            setOnClickListener {
                //TODO Add action
            }
        }
    }

    override fun getLayout() = R.layout.list_item_song

}