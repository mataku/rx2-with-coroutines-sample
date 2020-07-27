package com.mataku.rx2_with_coroutines_sample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mataku.rx2_with_coroutines_sample.BuildConfig
import com.mataku.rx2_with_coroutines_sample.model.entity.Artist
import com.mataku.rx2_with_coroutines_sample.model.entity.Track
import com.mataku.rx2_with_coroutines_sample.model.repository.TopArtistsRepository
import com.mataku.rx2_with_coroutines_sample.model.repository.TopTracksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ZipViewModel(
    private val topArtistsRepository: TopArtistsRepository,
    private val topTracksRepository: TopTracksRepository
) : ViewModel() {
    private val _zipLiveData = MutableLiveData<ZipUiModel>()
    fun getZipLiveData(): LiveData<ZipUiModel> {
        return _zipLiveData
    }

    fun request() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val artistRequestFlow = flowOf(
                    topArtistsRepository.getTopArtists(
                        apiKey = BuildConfig.API_KEY,
                        limit = 3,
                        page = 1
                    )
                )
                val tracksRequestFlow = flowOf(topTracksRepository.getTopTracks())
                artistRequestFlow.zip(tracksRequestFlow) { artistResult, tracksResult ->
                    val artists = artistResult.getOrNull() ?: emptyList()
                    val tracks = tracksResult.getOrNull() ?: emptyList()
                    ZipUiModel(
                        artist = artists.first(),
                        track = tracks.first()
                    )
                }.collect {
                    // Do in main thread
                    _zipLiveData.postValue(
                        it
                    )
                }
            }
        }
    }
}

data class ZipUiModel(
    val artist: Artist,
    val track: Track
)