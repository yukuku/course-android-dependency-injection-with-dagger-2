package com.techyourchance.dagger2course.screens.common

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import javax.inject.Inject

class ImageLoader @Inject constructor(
    private val activity: AppCompatActivity,
) {
    fun load(url: String, target: ImageView) {
        Glide.with(activity).load(url).into(target)
    }
}
