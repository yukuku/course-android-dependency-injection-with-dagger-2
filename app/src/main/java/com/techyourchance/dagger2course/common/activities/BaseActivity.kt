package com.techyourchance.dagger2course.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication

open class BaseActivity : AppCompatActivity() {

    val compositionRoot get() = (application as MyApplication).appCompositionRoot
}
