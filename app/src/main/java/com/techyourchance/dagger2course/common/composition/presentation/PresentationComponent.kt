package com.techyourchance.dagger2course.common.composition.presentation

import com.techyourchance.dagger2course.common.viewmvcs.ViewMvcFactory
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment
import com.techyourchance.dagger2course.usecases.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.usecases.FetchQuestionsUseCase
import dagger.Component

@Component(
    modules = [PresentationModule::class],
)
interface PresentationComponent {

    // convention: void method with single parameter is an **injector**
    fun inject(fragment: QuestionsListFragment)

    fun inject(activity: QuestionDetailsActivity)
}
