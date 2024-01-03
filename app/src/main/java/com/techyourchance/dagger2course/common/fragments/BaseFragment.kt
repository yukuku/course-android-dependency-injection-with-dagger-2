package com.techyourchance.dagger2course.common.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.createPresentationComponent()
    }
}
