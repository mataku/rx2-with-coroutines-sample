package com.mataku.rx2_with_coroutines_sample.model.repository

import com.mataku.rx2_with_coroutines_sample.BuildConfig
import com.mataku.rx2_with_coroutines_sample.model.entity.Artist
import com.mataku.rx2_with_coroutines_sample.model.presentation.NetworkResult
import com.mataku.rx2_with_coroutines_sample.model.presentation.TimeoutException
import com.mataku.rx2_with_coroutines_sample.model.service.CoroutinesApiService

class TopArtistsRepository(private val apiService: CoroutinesApiService) {
    suspend fun getTopArtists(
        apiKey: String,
        limit: Int,
        page: Int
    ): NetworkResult<List<Artist>> {
        return try {
            val result = apiService.getTopArtists(
                apiKey = BuildConfig.API_KEY,
                limit = 3,
                page = 1
            )
            val body = result.body()
            if (result.isSuccessful && body != null) {
                NetworkResult.success(body.topArtists.artists)
            } else {
                NetworkResult.failure(Throwable())
            }
        } catch (e: Exception) {
            NetworkResult.failure<List<Artist>>(TimeoutException())
        }
    }
}