package com.bsro.androidtestapp.di

import com.bsro.androidtestapp.ui.activities.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSecondActivity(): SecondActivity

}