package com.mataku.rx2_with_coroutines_sample.model.presentation

sealed class NetworkResult<T> {
    data class Progress<T>(var loading: Boolean) : NetworkResult<T>()
    data class Success<T>(var data: T) : NetworkResult<T>()
    data class Failure<T>(val throwable: Throwable) : NetworkResult<T>()

    companion object {
        fun <T> loading(isLoading: Boolean): NetworkResult<T> =
            Progress(isLoading)

        fun <T> success(data: T): NetworkResult<T> =
            Success(data)

        fun <T> failure(throwable: Throwable): NetworkResult<T> =
            Failure(throwable)
    }

    fun getOrNull(): T? {
        return if (this is Success) {
            this.data
        } else {
            null
        }
    }

    fun exceptionOrNull(): Throwable? {
        return if (this is Failure) {
            this.throwable
        } else {
            null
        }
    }
}

inline fun <T> NetworkResult<T>.onSuccess(action: (value: T) -> Unit): NetworkResult<T> {
    if (this is NetworkResult.Success) {
        action(this.data)
    }
    return this
}

inline fun <T> NetworkResult<T>.onFailure(action: (exception: Throwable) -> Unit): NetworkResult<T> {
    exceptionOrNull()?.let {
        action(it)
    }
    return this
}

class TimeoutException : Exception()