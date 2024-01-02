package com.techyourchance.dagger2course.common.composition.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity,
) {

    @Provides
    @ActivityScope
    fun layoutInflater() = activity.layoutInflater

    @Provides
    @ActivityScope
    fun screensNavigator() = ScreensNavigator(activity)

    @Provides
    @ActivityScope
    fun fragmentManager() = activity.supportFragmentManager
}
