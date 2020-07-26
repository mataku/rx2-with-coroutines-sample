package com.mataku.rx2_with_coroutines_sample.model.service.extension

import retrofit2.Response


object ErrorResponseConverter {
    @JvmStatic
    fun <T> convert(response: Response<T>): Throwable {
        return Throwable()
    }
}