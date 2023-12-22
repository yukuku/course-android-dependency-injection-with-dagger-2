package com.techyourchance.dagger2course.common.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.activities.BaseActivity
import com.techyourchance.dagger2course.common.composition.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.composition.PresentationModule

open class BaseFragment : Fragment() {
    val activityComponent get() = (requireActivity() as BaseActivity).activityComponent

    val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }
}
