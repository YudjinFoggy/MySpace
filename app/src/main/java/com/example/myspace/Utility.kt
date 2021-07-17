package com.example.myspace

import com.squareup.picasso.Picasso
import javax.inject.Inject

class Utility @Inject constructor() {
    fun getPicasso(): Picasso = Picasso.get()
}