package com.mataku.rx2_with_coroutines_sample.model.entity

import com.squareup.moshi.Json

data class TopArtistsApiResponse(
    @Json(name = "artists")
    val topArtists: TopArtists
)

data class TopArtists(
    @Json(name = "artist")
    val artists: List<Artist>
)