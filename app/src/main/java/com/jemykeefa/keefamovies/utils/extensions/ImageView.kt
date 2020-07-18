package com.jemykeefa.keefamovies.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.jemykeefa.keefamovies.R

fun ImageView.load(url: String) {
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_avatar)
        .into(this)
}