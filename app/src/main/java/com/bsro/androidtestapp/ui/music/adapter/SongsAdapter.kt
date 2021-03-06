package com.bsro.androidtestapp.ui.music.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bsro.androidtestapp.R
import com.bsro.androidtestapp.data.Song
import kotlinx.android.synthetic.main.list_item_song.view.*

class SongsAdapter(val items: List<Song>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val song = items[position]
        holder.itemView.apply {
            textViewSongTitle.text = song.name
            textViewArtist.text = song.artist
            textViewGenre.text = song.genre
            seekBarRating.progress = song.rating - 1
        }
    }

    override fun getItemCount() = items.size

    inner class SongViewHolder(view: View): RecyclerView.ViewHolder(view) { }

}