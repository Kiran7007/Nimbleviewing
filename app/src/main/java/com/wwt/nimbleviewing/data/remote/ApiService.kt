package com.wwt.nimbleviewing.data.remote

import com.wwt.nimbleviewing.AlbumArt
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * ApiService is responsible to define end points and its responses.
 */
interface ApiService {

    @GET
    suspend fun fetchRemoteData(@Url url: String): Response<List<AlbumArt>>
}