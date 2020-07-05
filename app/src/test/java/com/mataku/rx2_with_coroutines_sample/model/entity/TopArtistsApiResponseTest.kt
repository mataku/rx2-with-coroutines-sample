package com.mataku.rx2_with_coroutines_sample.model.entity

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlin.test.Test
import kotlin.test.assertNotNull

class TopArtistsApiResponseTest {

    @Test
    fun parse() {
        val mockJson = """
    {
      "artists": {
        "artist": [
          {
            "name": "The Weeknd",
            "playcount": "119469707",
            "listeners": "1573491",
            "mbid": "c8b03190-306c-4120-bb0b-6f2ebfc06ea9",
            "url": "https://www.last.fm/music/The+Weeknd",
            "streamable": "0",
            "image": [
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "small"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "medium"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "large"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "extralarge"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "mega"
              }
            ]
          },
          {
            "name": "Lady Gaga",
            "playcount": "332645284",
            "listeners": "4051129",
            "mbid": "650e7db6-b795-4eb5-a702-5ea2fc46c848",
            "url": "https://www.last.fm/music/Lady+Gaga",
            "streamable": "0",
            "image": [
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "small"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "medium"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "large"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "extralarge"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "mega"
              }
            ]
          },
          {
            "name": "Kanye West",
            "playcount": "295035029",
            "listeners": "4616139",
            "mbid": "164f0d73-1234-4e2c-8743-d77bf2191051",
            "url": "https://www.last.fm/music/Kanye+West",
            "streamable": "0",
            "image": [
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "small"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "medium"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "large"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "extralarge"
              },
              {
                "#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
                "size": "mega"
              }
            ]
          }
        ],
        "@attr": {
          "page": "1",
          "perPage": "3",
          "totalPages": "1073819",
          "total": "3221456"
        }
      }
    }
""".trimIndent()

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val jsonAdapter = moshi.adapter(TopArtistsApiResponse::class.java)
        val response = jsonAdapter.fromJson(mockJson)
        assertNotNull(response)
        assertNotNull(response.topArtists)
        assertNotNull(response.topArtists.artists)
    }
}