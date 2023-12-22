package com.techyourchance.dagger2course.common.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.activities.BaseActivity
import com.techyourchance.dagger2course.common.composition.PresentationCompositionRoot

open class BaseFragment : Fragment() {
    val activityCompositionRoot get() = (requireActivity() as BaseActivity).activityCompositionRoot

    val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }
}
