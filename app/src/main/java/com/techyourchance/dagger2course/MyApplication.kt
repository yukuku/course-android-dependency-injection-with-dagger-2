package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.dependnecyinjection.app.AppModule
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}