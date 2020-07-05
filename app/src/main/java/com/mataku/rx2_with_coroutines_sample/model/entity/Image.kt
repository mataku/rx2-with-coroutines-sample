package com.mataku.rx2_with_coroutines_sample.model.entity

import com.squareup.moshi.Json

data class Image(
    @Json(name = "#text")
    val imageUrl: String,

    @Json(name = "size")
    val size: String
)