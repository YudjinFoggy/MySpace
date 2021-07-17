package com.example.myspace.data.dto


import com.google.gson.annotations.SerializedName

class RateResponse{
    data class RateResponseItem(
        @SerializedName("events")
        val events: List<Event?>?,
        @SerializedName("featured")
        val featured: Boolean?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("imageUrl")
        val imageUrl: String?,
        @SerializedName("launches")
        val launches: List<Launche?>?,
        @SerializedName("newsSite")
        val newsSite: String?,
        @SerializedName("publishedAt")
        val publishedAt: String?,
        @SerializedName("summary")
        val summary: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("url")
        val url: String?
    ) {
        data class Event(
            @SerializedName("id")
            val id: String?,
            @SerializedName("provider")
            val provider: String?
        )

        data class Launche(
            @SerializedName("id")
            val id: String?,
            @SerializedName("provider")
            val provider: String?
        )
    }
}