package com.mataku.rx2_with_coroutines_sample.model.service

import com.mataku.rx2_with_coroutines_sample.model.entity.TopArtistsApiResponse
import com.mataku.rx2_with_coroutines_sample.model.entity.TopTracksApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoroutinesApiService {
    @GET("/2.0/?method=chart.gettopartists&format=json")
    suspend fun getTopArtists(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int,
        @Query("page") page: Int
    ): Response<TopArtistsApiResponse>

    @GET("/2.0/?method=chart.gettoptracks&format=json")
    suspend fun getTopTracks(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int,
        @Query("page") page: Int
    ): Response<TopTracksApiResponse>
}