package com.techyourchance.dagger2course.common.fragments

import android.util.Log
import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    val presentationComponent by lazy {
        val activityComponent = (requireActivity() as BaseActivity).activityComponent
        Log.i("BaseFragment", "this: ${this::class.java.simpleName} activity component: ${System.identityHashCode(activityComponent)}")

        val res = activityComponent.createPresentationComponent()
        Log.i("BaseFragment", "this: ${this::class.java.simpleName} presentation component: ${System.identityHashCode(res)}")
        res
    }
}
