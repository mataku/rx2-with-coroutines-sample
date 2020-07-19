package com.mataku.rx2_with_coroutines_sample.model.repository

import android.util.Log
import com.mataku.rx2_with_coroutines_sample.BuildConfig
import com.mataku.rx2_with_coroutines_sample.model.entity.Track
import com.mataku.rx2_with_coroutines_sample.model.presentation.NetworkResult
import com.mataku.rx2_with_coroutines_sample.model.presentation.TimeoutException
import com.mataku.rx2_with_coroutines_sample.model.service.CoroutinesApiService

class TopTracksRepository(private val apiService: CoroutinesApiService) {
    suspend fun getTopTracks(): NetworkResult<List<Track>> {
        return try {
            val result = apiService.getTopTracks(
                apiKey = BuildConfig.API_KEY,
                limit = 3,
                page = 1
            )
            val body = result.body()
            if (result.isSuccessful && body != null) {
                NetworkResult.success(body.topTracks.tracks)
            } else {
                NetworkResult.failure(Throwable())
            }
        } catch (e: Exception) {
            Log.i("MATAKUDEBUG", e.toString())
            NetworkResult.failure<List<Track>>(TimeoutException())
        }
    }
}