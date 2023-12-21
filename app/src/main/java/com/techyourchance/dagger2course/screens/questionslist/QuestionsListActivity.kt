package com.techyourchance.dagger2course.screens.questionslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.dialogs.ServerErrorDialogFragment
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.usecases.FetchQuestionsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

class QuestionsListActivity : AppCompatActivity(), QuestionsListViewMvc.Listener {
    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var viewMvc: QuestionsListViewMvc
    private lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase

    private var isDataLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewMvc = QuestionsListViewMvc(layoutInflater, null)
        setContentView(viewMvc.rootView)

        fetchQuestionsUseCase = FetchQuestionsUseCase()
    }

    override fun onStart() {
        super.onStart()
        viewMvc.addListener(this)
        if (!isDataLoaded) {
            fetchQuestions()
        }
    }

    override fun onStop() {
        super.onStop()
        viewMvc.removeListener(this)
        coroutineScope.coroutineContext.cancelChildren()
    }

    private fun fetchQuestions() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            when (val result = fetchQuestionsUseCase.fetchQuestions()) {
                is FetchQuestionsUseCase.Result.Success -> {
                    viewMvc.bindQuestions(result.questions)
                    isDataLoaded = true
                }

                FetchQuestionsUseCase.Result.Failure -> {
                    onFetchFailed()
                }
            }
            viewMvc.hideProgressIndication()
        }
    }

    private fun onFetchFailed() {
        supportFragmentManager.beginTransaction()
            .add(ServerErrorDialogFragment.newInstance(), null)
            .commitAllowingStateLoss()
    }

    override fun onRefreshClicked() {
        fetchQuestions()
    }

    override fun onQuestionClicked(id: String) {
        QuestionDetailsActivity.start(this, id)
    }
}