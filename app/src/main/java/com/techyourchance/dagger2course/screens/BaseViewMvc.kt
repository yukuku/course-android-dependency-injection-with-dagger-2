package com.techyourchance.dagger2course.screens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

open class BaseViewMvc<LISTENER>(
    layoutInflater: LayoutInflater,
    container: ViewGroup?,
    @LayoutRes layoutResId: Int,
) {
    protected val listeners = mutableListOf<LISTENER>()

    fun addListener(listener: LISTENER) {
        listeners += listener
    }

    fun removeListener(listener: LISTENER) {
        listeners -= listener
    }

    val rootView: View = layoutInflater.inflate(layoutResId, container, false)

    protected fun <T : View> findViewById(id: Int): T {
        return rootView.findViewById(id)
    }
}
