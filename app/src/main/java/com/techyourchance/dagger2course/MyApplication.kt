package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.composition.AppComponent
import com.techyourchance.dagger2course.common.composition.AppModule
import com.techyourchance.dagger2course.common.composition.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
    }
}