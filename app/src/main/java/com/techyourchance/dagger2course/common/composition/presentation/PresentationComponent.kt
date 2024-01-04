package com.techyourchance.dagger2course.common.composition.presentation

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [],
)
@PresentationScope
interface PresentationComponent {

    // convention: void method with single parameter is an **injector**
    fun inject(fragment: QuestionsListFragment)

    fun inject(activity: QuestionDetailsActivity)
}
