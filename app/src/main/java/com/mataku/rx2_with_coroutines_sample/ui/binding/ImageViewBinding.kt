package com.mataku.rx2_with_coroutines_sample.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageViewBinding {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageUrl(view: ImageView, url: String?) {
        url ?: return

        Glide.with(view).load(url).into(view)
    }
}