package com.wwt.nimbleviewing.model

data class Album(val userId: Int, val id: Int, val title: String)

data class AlbumArt(val albumId: Int, val title: String, val id: Int, val url: String, val thumbnailUrl: String)