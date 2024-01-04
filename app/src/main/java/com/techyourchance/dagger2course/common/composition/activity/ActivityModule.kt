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
    fun activity() = activity

    @Provides
    fun layoutInflater() = activity.layoutInflater

    @Provides
    @ActivityScope
    fun screensNavigator() = ScreensNavigator(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager
}
