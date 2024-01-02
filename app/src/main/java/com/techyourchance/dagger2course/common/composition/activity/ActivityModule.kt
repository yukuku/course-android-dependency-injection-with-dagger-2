package com.techyourchance.dagger2course.common.composition.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.composition.app.AppComponent
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity,
    private val appComponent: AppComponent,
) {

    @Provides
    fun layoutInflater() = activity.layoutInflater

    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    @Provides
    fun screensNavigator() = screensNavigator

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun stackoverflowApi() = appComponent.stackoverflowApi()
}
