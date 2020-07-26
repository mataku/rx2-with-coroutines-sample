package com.mataku.rx2_with_coroutines_sample.fixture


object TopArtistsResponse {
    fun get(): String {
        return """
        {
            "artists": {
            "artist": [
            {
                "name": "The Weeknd",
                "playcount": "122737250",
                "listeners": "1593493",
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
            }
            ],
            "@attr": {
            "page": "1",
            "perPage": "1",
            "totalPages": "3488434",
            "total": "3488434"
        }
        }
        }
        """
    }
}
