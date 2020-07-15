package com.mataku.rx2_with_coroutines_sample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mataku.rx2_with_coroutines_sample.model.entity.Artist
import com.mataku.rx2_with_coroutines_sample.model.entity.Track

class ZipViewModel : ViewModel() {
    private val _zipLiveData: MutableLiveData<ZipUiModel>()
    fun getZipLiveData(): LiveData<ZipUiModel> {
        return _zipLiveData
    }

    fun
}

data class ZipUiModel(
    val artist: Artist,
    val track: Track
)