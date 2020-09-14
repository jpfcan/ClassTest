package com.bsro.androidtestapp.ui.music.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.bsro.androidtestapp.R
import com.bsro.androidtestapp.data.Song
import com.bsro.androidtestapp.ui.music.SongsViewModel
import com.bsro.androidtestapp.ui.music.adapter.SongsAdapter
import com.bsro.androidtestapp.ui.music.adapter.items.ArtistItem
import com.bsro.androidtestapp.ui.music.adapter.items.SongItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_two.*

class FragmentTwo : Fragment() {

    val songsAdapter = GroupAdapter<GroupieViewHolder>()
    val viewModel: SongsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_two, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSetName.setOnClickListener {
            val args = Bundle().apply {
                putString("userId", editTextName.text.toString())
            }
            findNavController().navigate(R.id.action_home_to_fragmentOne, args)
        }

        recyclerViewSongs.layoutManager = LinearLayoutManager(context, VERTICAL, false)
        recyclerViewSongs.adapter = songsAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getSongsLiveData().observe(viewLifecycleOwner, Observer { songs ->
            songsAdapter.addAll(
                songs.map { SongItem(it) }
            )
        })
    }

}