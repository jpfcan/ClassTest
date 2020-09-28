package com.bsro.androidtestapp.di

import com.bsro.androidtestapp.music.ui.fragment.FragmentTwo
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): FragmentTwo

}