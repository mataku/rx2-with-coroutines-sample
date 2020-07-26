package com.mataku.rx2_with_coroutines_sample.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mataku.rx2_with_coroutines_sample.helper.TestObserver
import com.mataku.rx2_with_coroutines_sample.model.entity.Artist
import com.mataku.rx2_with_coroutines_sample.model.entity.Track
import com.mataku.rx2_with_coroutines_sample.model.presentation.NetworkResult
import com.mataku.rx2_with_coroutines_sample.model.repository.TopArtistsRepository
import com.mataku.rx2_with_coroutines_sample.model.repository.TopTracksRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.mockito.Mockito
import kotlin.test.Test
import kotlin.test.assertNotNull

@ExperimentalCoroutinesApi
class ZipViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mockArtist = Artist(
        imageList = listOf(),
        name = "PassCode",
        url = "https://www.last.fm/ja/music/PassCode"
    )

    private val mockTrack = Track(
        name = "Taking You Out",
        url = "https://www.last.fm/ja/music/PassCode/_/Taking+You+Out",
        playcount = 1
    )

    private val mockTrack2 = Track(
        name = "Taking You Outt",
        url = "https://www.last.fm/ja/music/PassCode/_/Taking+You+Out",
        playcount = 1
    )

    @Test
    fun request_success() {
        val topArtistsRepo = Mockito.mock(TopArtistsRepository::class.java)
        val topTracksRepo = Mockito.mock(TopTracksRepository::class.java)

        val viewModel = ZipViewModel(
            topTracksRepository = topTracksRepo,
            topArtistsRepository = topArtistsRepo
        )

        runBlockingTest {
            Mockito.`when`(topArtistsRepo.getTopArtists()).thenReturn(
                NetworkResult.success(listOf(mockArtist))
            )

            Mockito.`when`(topTracksRepo.getTopTracks()).thenReturn(
                NetworkResult.success(listOf(mockTrack))
            )
            val zipUiModelObserver = TestObserver<ZipUiModel>()
            viewModel.getZipLiveData().observeForever(zipUiModelObserver)
            viewModel.request()
            zipUiModelObserver.await()
            val result = zipUiModelObserver.get()
            assertNotNull(result)
            Assert.assertEquals(result.track, mockTrack)
            Assert.assertEquals(result.artist, mockArtist)
        }
    }
}