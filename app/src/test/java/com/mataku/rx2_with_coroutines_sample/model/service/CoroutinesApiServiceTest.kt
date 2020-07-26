package com.mataku.rx2_with_coroutines_sample.model.service

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.test.BeforeTest

class CoroutinesApiServiceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var retrofit: Retrofit
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @BeforeTest
    fun setup() {
        mockWebServer = MockWebServer()
        retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(mockWebServer.url(""))
            .build()
    }
}