package com.techyourchance.dagger2course.common.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.activities.BaseActivity
import com.techyourchance.dagger2course.common.composition.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.composition.presentation.PresentationModule

open class BaseFragment : Fragment() {
    val activityComponent get() = (requireActivity() as BaseActivity).activityComponent

    val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .activityComponent(activityComponent)
            .presentationModule(PresentationModule())
            .build()
    }
}
