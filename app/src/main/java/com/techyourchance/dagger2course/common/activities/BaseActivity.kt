package com.techyourchance.dagger2course.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.composition.ActivityCompositionRoot
import com.techyourchance.dagger2course.common.composition.PresentationCompositionRoot

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot

    val activityCompositionRoot by lazy { ActivityCompositionRoot(this, appCompositionRoot) }

    val compositionRoot by lazy { PresentationCompositionRoot(activityCompositionRoot) }
}
