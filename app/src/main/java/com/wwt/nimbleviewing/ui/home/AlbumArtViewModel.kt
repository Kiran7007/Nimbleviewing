package com.wwt.nimbleviewing.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wwt.nimbleviewing.model.AlbumArt
import com.wwt.nimbleviewing.BuildConfig
import com.wwt.nimbleviewing.data.repository.AlbumArtRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlbumArtViewModel(private val artRepository: AlbumArtRepository) : ViewModel() {

    private val _albumArtList = MutableLiveData<List<AlbumArt>>()
    val albumArtList: LiveData<List<AlbumArt>> = _albumArtList

    fun getAlbumsArt() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val response =
                    withContext(Dispatchers.IO) {
                        artRepository.getAlbumArts(
                            BuildConfig.ALBUM_ART_ENDPOINT_URL
                        )
                    }
                if (response.isSuccessful) {
                    _albumArtList.value = response.body() ?: emptyList()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}