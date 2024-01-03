package com.techyourchance.dagger2course.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.composition.activity.ActivityModule

open class BaseActivity : AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        appComponent.createActivityComponent(ActivityModule(this))
    }

    val presentationComponent by lazy {
        activityComponent.createPresentationComponent()
    }
}
