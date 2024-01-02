package com.techyourchance.dagger2course.common.composition.activity

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.common.composition.app.AppComponent
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class],
)
@ActivityScope
interface ActivityComponent {

    fun layoutInflater(): LayoutInflater

    fun fragmentManager(): FragmentManager

    fun screensNavigator(): ScreensNavigator

    fun stackoverflowApi(): StackoverflowApi
}
