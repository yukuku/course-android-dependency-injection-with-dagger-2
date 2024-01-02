package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.composition.app.AppComponent
import com.techyourchance.dagger2course.common.composition.app.AppModule
import com.techyourchance.dagger2course.common.composition.app.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
    }
}
