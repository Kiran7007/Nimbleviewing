package com.wwt.nimbleviewing.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.wwt.nimbleviewing.AlbumArt
import com.wwt.nimbleviewing.R
import com.wwt.nimbleviewing.loadImage

class AlbumListAdapter : RecyclerView.Adapter<AlbumViewHolder>() {
    private val data: MutableList<AlbumArt> = mutableListOf()

    fun submitList(albums: List<AlbumArt>) {
        data.clear()
        data.addAll(albums)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder =
        AlbumViewHolder(
            parent.inflater().inflate(R.layout.list_item_album, parent, false)
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) =
        holder.bind(data[position])

    private fun ViewGroup.inflater(): LayoutInflater = LayoutInflater.from(context)
}

class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(album: AlbumArt) = with(itemView) {
        findViewById<AppCompatImageView>(R.id.album_art).loadImage(album.url)
        findViewById<TextView>(R.id.tv_title).text =
            String(
                album.title.toCharArray()
                    .filter { !it.equals('e', false) }.toCharArray()
            )
    }
}

