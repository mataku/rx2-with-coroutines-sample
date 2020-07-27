package com.mataku.rx2_with_coroutines_sample.model.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mataku.rx2_with_coroutines_sample.helper.TestCoroutinesRule
import com.mataku.rx2_with_coroutines_sample.model.entity.Artist
import com.mataku.rx2_with_coroutines_sample.model.entity.TopArtists
import com.mataku.rx2_with_coroutines_sample.model.entity.TopArtistsApiResponse
import com.mataku.rx2_with_coroutines_sample.model.presentation.NetworkResult
import com.mataku.rx2_with_coroutines_sample.model.service.CoroutinesApiService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class TopArtistsRepositoryTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val testCoroutineRule = TestCoroutinesRule()

    @Mock
    private lateinit var apiService: CoroutinesApiService

    private val apiKey = "test"
    private val limit = 1
    private val page = 1

    @BeforeTest
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    private val topArtists = TopArtists(
        listOf(
            Artist(
                name = "PassCode",
                imageList = emptyList(),
                url = "https://example.com"
            )
        )
    )

    private val mockResponse = TopArtistsApiResponse(topArtists)

    @Test
    fun getTopArtists_success() = testCoroutineRule.runBlockingTest {
        Mockito.`when`(
            apiService.getTopArtists(
                apiKey = apiKey,
                limit = limit,
                page = page
            )
        ).thenReturn(
            Response.success(mockResponse)
        )

        val repo = TopArtistsRepository(apiService = apiService)
        val result = repo.getTopArtists(
            apiKey, limit, page
        )
        assertTrue(result is NetworkResult.Success)
        assertNotNull(result.getOrNull())
    }
}