package com.example.myspace.recycler


import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myspace.R
import com.example.myspace.data.entity.Rate


class SpaceNewsAdapter(val news: List<Rate>) :
    RecyclerView.Adapter<SpaceNewsAdapter.SpaceNewsViewHolder>() {

    inner class SpaceNewsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SimpleDateFormat")
        fun setData(itemView: View, position: Int) {

            val spaceNews = news[position]

            Glide.with(view.context).load(spaceNews.imageUrl).into(
                itemView.findViewById<ImageView>(
                    R.id.image_url
                )
            )

            itemView.findViewById<TextView>(R.id.news_site).text = spaceNews.newsSite
            itemView.findViewById<TextView>(R.id.title).text = spaceNews.title
            itemView.findViewById<TextView>(R.id.published_at).text = DateFormat.format(
                "yyyy-MM-dd",
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(spaceNews.publishedAt)
            )

            itemView.setOnClickListener {
                val intent = Intent.makeMainSelectorActivity(
                    Intent.ACTION_MAIN,
                    Intent.CATEGORY_APP_BROWSER
                )
                intent.data = spaceNews.url?.toUri();
                startActivity(view.context, intent, null);
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SpaceNewsViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_space, viewGroup, false)
        return SpaceNewsViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SpaceNewsViewHolder, position: Int) {
        viewHolder.setData(viewHolder.itemView, position)
    }

    override fun getItemCount() = news.size
}