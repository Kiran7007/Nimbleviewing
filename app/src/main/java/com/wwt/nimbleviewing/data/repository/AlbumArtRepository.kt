package com.wwt.nimbleviewing.data.repository

import com.wwt.nimbleviewing.model.AlbumArt
import retrofit2.Response

interface AlbumArtRepository {

    suspend fun getAlbumArts(url: String): Response<List<AlbumArt>>
}