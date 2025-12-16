package com.example.listasg

import android.media.Image
import androidx.annotation.DrawableRes

data class Series(
    val title: String,
    @DrawableRes val image: Int,
    val description: String
)
