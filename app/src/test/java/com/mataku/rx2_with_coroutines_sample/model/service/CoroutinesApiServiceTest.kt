package com.mataku.rx2_with_coroutines_sample.model.service

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mataku.rx2_with_coroutines_sample.fixture.TopArtistsResponse
import com.mataku.rx2_with_coroutines_sample.helper.TestCoroutinesRule
import com.mataku.rx2_with_coroutines_sample.helper.runBlocking
import com.mataku.rx2_with_coroutines_sample.model.entity.TopArtists
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.Rule
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class CoroutinesApiServiceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var retrofit: Retrofit
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val testCoroutineRule = TestCoroutinesRule()

    @BeforeTest
    fun setup() {
        mockWebServer = MockWebServer()
        retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(mockWebServer.url("/"))
            .client(OkHttpClient.Builder().build())
            .build()
    }

    @AfterTest
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun getTopArtists_success() = testCoroutineRule.runBlocking {
        val requestPath = "/2.0/?method=chart.gettopartists&format=json"

        val mockResponseBody = TopArtistsResponse.get()
        val dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                val path = request.path
                return if (path == null || !path.contains(requestPath)) {
                    MockResponse().setResponseCode(404)
                } else {
                    MockResponse().setBody(mockResponseBody).setResponseCode(200)
                }
            }
        }
        mockWebServer.dispatcher = dispatcher
        val response = retrofit.create(CoroutinesApiService::class.java).getTopArtists(
            apiKey = "test",
            limit = 1,
            page = 1
        )
        assertNotNull(response.body())
        assertTrue(response.body()?.topArtists is TopArtists)
    }
}