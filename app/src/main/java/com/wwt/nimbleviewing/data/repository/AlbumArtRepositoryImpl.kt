package com.wwt.nimbleviewing.data.repository

import com.wwt.nimbleviewing.data.remote.ApiService

class AlbumArtRepositoryImpl(private val apiService: ApiService) : AlbumArtRepository {

    override suspend fun getAlbumArts(url: String) = apiService.fetchRemoteData(url)
}