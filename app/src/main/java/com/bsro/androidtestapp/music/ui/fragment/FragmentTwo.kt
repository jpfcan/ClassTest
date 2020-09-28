package com.bsro.androidtestapp.music.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.bsro.androidtestapp.R
import com.bsro.androidtestapp.music.ui.SongsViewModel
import com.bsro.androidtestapp.music.ui.adapter.items.SongItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_two.*
import javax.inject.Inject

class FragmentTwo : DaggerFragment() {

    @Inject lateinit var testString: String

    @Inject lateinit var viewModel: SongsViewModel

    val songsAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_two, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSetName.setOnClickListener {
            val name = editTextName.text.toString()
            findNavController().navigate(FragmentTwoDirections.actionHomeToFragmentOne(name))
        }

        recyclerViewSongs.layoutManager = LinearLayoutManager(context, VERTICAL, false)
        recyclerViewSongs.adapter = songsAdapter

        textViewTitle.text = testString
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