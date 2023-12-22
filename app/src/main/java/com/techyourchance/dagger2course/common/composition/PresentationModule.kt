package com.techyourchance.dagger2course.common.composition

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.common.viewmvcs.ViewMvcFactory
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.usecases.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.usecases.FetchQuestionsUseCase
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val activityComponent: ActivityComponent) {

    @Provides
    fun layoutInflater() = activityComponent.layoutInflater()

    @Provides
    fun fragmentManager() = activityComponent.fragmentManager()

    @Provides
    fun stackoverflowApi() = activityComponent.stackoverflowApi()

    @Provides
    fun screensNavigator() = activityComponent.screensNavigator()

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionDetailsUseCase(stackoverflowApi)
}
