package com.example.listasg

import androidx.annotation.DrawableRes

data class Series(
    val title: String,
    @DrawableRes val image: Int,
    val description: String
)
