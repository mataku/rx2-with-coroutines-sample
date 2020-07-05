package com.mataku.rx2_with_coroutines_sample.model.entity

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET


interface TopArtistsApiService {
    @GET("/2.0/?method=chart.gettopartists?format=json")
    fun getTopArtists(
        apiKey: String,
        limit: Int,
        page: Int
    ): Single<Response<TopArtistsApiResponse>>
}
