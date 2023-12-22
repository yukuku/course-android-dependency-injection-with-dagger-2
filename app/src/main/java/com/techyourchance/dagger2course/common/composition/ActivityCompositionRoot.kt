package com.techyourchance.dagger2course.common.composition

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.viewmvcs.ViewMvcFactory
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.usecases.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.usecases.FetchQuestionsUseCase

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot,
) {

    val layoutInflater get() = activity.layoutInflater

    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val fragmentManager = activity.supportFragmentManager

    val dialogsNavigator by lazy {
        DialogsNavigator(fragmentManager)
    }

    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)

    val stackoverflowApi get() = appCompositionRoot.stackoverflowApi

    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)

    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)

}
