package com.techyourchance.dagger2course.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.composition.ActivityModule
import com.techyourchance.dagger2course.common.composition.DaggerActivityComponent
import com.techyourchance.dagger2course.common.composition.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.composition.PresentationModule

open class BaseActivity : AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this, appComponent))
            .build()
    }

    val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }
}
