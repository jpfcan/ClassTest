package com.bsro.androidtestapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bsro.androidtestapp.R
import kotlinx.android.synthetic.main.fragment_two.*
import layout.FragmentThree

class FragmentTwo : Fragment() {

    companion object {
        private const val ARG_1_KEY = "argument1Key"

        @JvmStatic
        fun newInstance(argument: String) = FragmentTwo().apply {
            arguments = Bundle().apply {
                putString(ARG_1_KEY, argument)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_two, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToFragmentThreeButton.setOnClickListener {
            activity?.supportFragmentManager?.let {
                it.beginTransaction().apply {
                    replace(R.id.container, FragmentThree())
                    addToBackStack("transactionFragmentThree")
                    commit()
                }
            }
        }
    }

}