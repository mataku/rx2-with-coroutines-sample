package com.mataku.rx2_with_coroutines_sample.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageViewBinding {

    @BindingAdapter
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view).load(url).into(view)
    }
}