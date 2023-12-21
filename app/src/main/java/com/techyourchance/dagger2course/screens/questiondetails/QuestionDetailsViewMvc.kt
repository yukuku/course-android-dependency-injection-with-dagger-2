package com.techyourchance.dagger2course.screens.questiondetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.BaseViewMvc
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar

class QuestionDetailsViewMvc(
    layoutInflater: LayoutInflater,
    container: ViewGroup?,
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>(
    layoutInflater,
    container,
    R.layout.layout_question_details,
) {
    private val toolbar: MyToolbar = findViewById(R.id.toolbar)
    private val swipeRefresh: SwipeRefreshLayout
    private val txtQuestionBody: TextView = findViewById(R.id.txt_question_body)

    interface Listener {
        fun onBackPressed()
    }

    init {
        // init toolbar
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onBackPressed()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }

    fun setQuestionText(html: CharSequence) {
        txtQuestionBody.text = html
    }
}
