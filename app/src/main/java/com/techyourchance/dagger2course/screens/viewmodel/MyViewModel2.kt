package com.techyourchance.dagger2course.screens.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.questions.Question
import javax.inject.Inject

class MyViewModel2 @ViewModelInject constructor(
        private val fetchQuestionsUseCase: FetchQuestionsUseCase,
        private val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase
): ViewModel() {

    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = _questions

}