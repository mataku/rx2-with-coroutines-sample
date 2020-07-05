package com.mataku.rx2_with_coroutines_sample.model.entity

import com.squareup.moshi.Json

data class Artist(
    val name: String,
    val url: String,

    @Json(name = "image")
    val imageList: List<Image>
)