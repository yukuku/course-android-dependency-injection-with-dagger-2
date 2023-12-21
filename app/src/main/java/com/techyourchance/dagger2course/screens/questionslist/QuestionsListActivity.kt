package com.techyourchance.dagger2course.screens.questionslist

import android.os.Bundle
import android.widget.FrameLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.common.activities.BaseActivity

class QuestionsListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            FrameLayout(this).apply {
                id = R.id.frame
            }
        )

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame, QuestionsListFragment())
                .commit()
        }
    }
}
