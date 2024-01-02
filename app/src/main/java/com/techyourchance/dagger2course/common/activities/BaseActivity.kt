package com.techyourchance.dagger2course.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.composition.activity.ActivityModule
import com.techyourchance.dagger2course.common.composition.activity.DaggerActivityComponent
import com.techyourchance.dagger2course.common.composition.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.composition.presentation.PresentationModule

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
