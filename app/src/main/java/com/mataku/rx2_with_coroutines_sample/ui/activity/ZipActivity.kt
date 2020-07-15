package com.mataku.rx2_with_coroutines_sample.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mataku.rx2_with_coroutines_sample.R
import com.mataku.rx2_with_coroutines_sample.databinding.ActivityZipBinding

class ZipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityZipBinding>(
            this,
            R.layout.activity_zip
        )
    }
}