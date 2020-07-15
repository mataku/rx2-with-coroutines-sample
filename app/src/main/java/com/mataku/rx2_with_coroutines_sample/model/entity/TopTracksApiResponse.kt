package com.mataku.rx2_with_coroutines_sample.model.entity

import com.squareup.moshi.Json


data class TopTracksApiResponse(
    @Json(name = "tracks")
    val topTracks: TopTracks
)

data class TopTracks(
    @Json(name = "track")
    val tracks: List<Track>
)
