package com.example.myspace.ui.gallery

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView
import com.bumptech.glide.Glide


class CustomGalleryAdapter(private val images: IntArray, val context: Context?) : BaseAdapter() {

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @Suppress("DEPRECATION")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = ImageView(context)
        context?.let {
            Glide.with(it).load(images[position])
                .into(imageView)
        }

        //imageView.setImageResource(images[position])
        imageView.layoutParams = Gallery.LayoutParams(400, 400)
        return imageView
    }
}