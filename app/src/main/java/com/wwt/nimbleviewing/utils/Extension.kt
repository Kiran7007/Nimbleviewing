package com.wwt.nimbleviewing

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImage(imageUrl: String?) {
    imageUrl?.let {
        val url = GlideUrl(
            imageUrl, LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build()
        )
        Glide.with(context)
            .load(url).apply(RequestOptions().placeholder(R.mipmap.ic_launcher_round).fitCenter())
            .into(this)
    }
}