package com.techyourchance.dagger2course.screens.questiondetails

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.questions.QuestionWithBody
import com.techyourchance.dagger2course.screens.BaseViewMvc
import com.techyourchance.dagger2course.screens.common.ImageLoader
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar

class QuestionDetailsViewMvc(
    layoutInflater: LayoutInflater,
    container: ViewGroup?,
    private val imageLoader: ImageLoader,
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>(
    layoutInflater,
    container,
    R.layout.layout_question_details,
) {
    private val toolbar: MyToolbar = findViewById(R.id.toolbar)
    private val swipeRefresh: SwipeRefreshLayout
    private val txtQuestionBody: TextView = findViewById(R.id.txt_question_body)
    private val imgUser: ImageView = findViewById(R.id.img_user)

    interface Listener {
        fun onBackClicked()
    }

    init {
        // init toolbar
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onBackClicked()
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

    fun setQuestion(question: QuestionWithBody) {
        val html = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(question.body, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            Html.fromHtml(question.body)
        }

        imageLoader.load(question.owner.imageUrl, imgUser)
        txtQuestionBody.text = html
    }
}
