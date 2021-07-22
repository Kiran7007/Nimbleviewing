package com.wwt.nimbleviewing.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.wwt.nimbleviewing.AlbumArt
import com.wwt.nimbleviewing.BuildConfig
import com.wwt.nimbleviewing.databinding.ActivityScrollingBinding
import org.koin.android.ext.android.inject
import java.util.*

class ScrollingActivity : AppCompatActivity() {
    private val listAdapter: AlbumListAdapter by lazy { AlbumListAdapter() }

    private val viewModel: AlbumArtViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(ActivityScrollingBinding.inflate(LayoutInflater.from(this), null, false)) {
            setContentView(root)
            setSupportActionBar(toolbar)
            toolbarLayout.title = this@ScrollingActivity.title

            container.albumList.adapter = listAdapter

            fab.setOnClickListener {
                Snackbar.make(
                    container.albumList,
                    "Display album titles and images from ${BuildConfig.BASE_URL}",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        observeAlbumList()
    }

    private fun observeAlbumList() {
        viewModel.albumArtList.observe(this,
            Observer<List<AlbumArt>> {
                listAdapter.submitList(it)
            })
        viewModel.getAlbumsArt()
    }
}