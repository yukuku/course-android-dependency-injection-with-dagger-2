package com.techyourchance.dagger2course.common.activities

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.composition.activity.ActivityModule

open class BaseActivity : AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        val res = appComponent.createActivityComponent(ActivityModule(this))
        Log.i("BaseActivity", "this: ${this::class.java.simpleName} activity component: ${System.identityHashCode(res)}")
        res
    }

    val presentationComponent by lazy {
        val res = activityComponent.createPresentationComponent()
        Log.i("BaseActivity", "this: ${this::class.java.simpleName} presentation component: ${System.identityHashCode(res)}")
        res
    }
}
