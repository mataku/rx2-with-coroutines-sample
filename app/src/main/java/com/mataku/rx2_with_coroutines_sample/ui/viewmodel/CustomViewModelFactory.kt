package com.mataku.rx2_with_coroutines_sample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mataku.rx2_with_coroutines_sample.model.repository.TopArtistsRepository
import com.mataku.rx2_with_coroutines_sample.model.repository.TopTracksRepository

class CustomViewModelFactory(
    private val topTracksRepository: TopTracksRepository,
    private val topArtistsRepository: TopArtistsRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        with(modelClass) {
            when {
                isAssignableFrom(ZipViewModel::class.java) -> {
                    return ZipViewModel(
                        topArtistsRepository, topTracksRepository
                    ) as T
                }
                else -> {
                    throw IllegalArgumentException("${modelClass.name} is unknown")
                }
            }
        }
    }
}