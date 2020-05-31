package com.example.lab6.entities

import com.example.lab6.entities.PageInfo

data class PlaylistsResponse(
    val kind: String,
    val etag: String,
    val nextPageToken: String?,
    val prevPageToken: String?,
    val pageInfo: PageInfo,
    val items: Array<PlaylistItem>
)