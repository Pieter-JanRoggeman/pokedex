package com.pj.pokedex.common

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageByUrl(url: String) {

    //Implementation Glide
    Glide.with(context)
        .load(url)
        .into(this)

}