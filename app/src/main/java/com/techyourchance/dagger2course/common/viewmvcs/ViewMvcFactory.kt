package com.techyourchance.dagger2course.common.viewmvcs

import android.view.LayoutInflater
import android.view.ViewGroup
import com.techyourchance.dagger2course.screens.common.ImageLoader
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsViewMvc
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
) {
    fun createQuestionsListViewMvc(container: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, container)
    }

    fun createQuestionDetailsViewMvc(container: ViewGroup?): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvc(layoutInflater, container, imageLoader)
    }
}
