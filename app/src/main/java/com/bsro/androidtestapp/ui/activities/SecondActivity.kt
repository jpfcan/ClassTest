package com.bsro.androidtestapp.ui.activities

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bsro.androidtestapp.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val navController = findNavController(this, R.id.homeNavHostFragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.home, R.id.group, R.id.music -> {
                    bottomNavigation.visibility = VISIBLE
                }
                else -> bottomNavigation.visibility = GONE
            }
        }

        bottomNavigation.setupWithNavController(navController)
    }

}