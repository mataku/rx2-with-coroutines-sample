package com.mataku.rx2_with_coroutines_sample.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.mataku.rx2_with_coroutines_sample.R
import com.mataku.rx2_with_coroutines_sample.databinding.ActivityZipBinding
import com.mataku.rx2_with_coroutines_sample.model.ApiClient
import com.mataku.rx2_with_coroutines_sample.model.repository.TopArtistsRepository
import com.mataku.rx2_with_coroutines_sample.model.repository.TopTracksRepository
import com.mataku.rx2_with_coroutines_sample.model.service.CoroutinesApiService
import com.mataku.rx2_with_coroutines_sample.ui.viewmodel.CustomViewModelFactory
import com.mataku.rx2_with_coroutines_sample.ui.viewmodel.ZipViewModel

class ZipActivity : AppCompatActivity() {

    // TODO: Inject
    private val apiService = ApiClient.create(CoroutinesApiService::class.java)
    private val topArtistsRepository = TopArtistsRepository(apiService)
    private val topTracksRepository = TopTracksRepository(apiService)

    private val viewModel: ZipViewModel by viewModels<ZipViewModel> {
        CustomViewModelFactory(
            topArtistsRepository = topArtistsRepository,
            topTracksRepository = topTracksRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityZipBinding>(
            this,
            R.layout.activity_zip
        )
        viewModel.getZipLiveData().observe(this, Observer {
            Log.i("MATAKUDEBUG", it.artist.toString())
            Log.i("MATAKUDEBUG", it.track.toString())
            binding.artist = it.artist
            binding.track = it.track
        })
        viewModel.request()
    }
}