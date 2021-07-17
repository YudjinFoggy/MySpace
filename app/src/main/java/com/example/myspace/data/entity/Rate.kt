package com.example.myspace.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "space_table")
data class Rate(

    val imageUrl: String?,
    val newsSite: String?,
    val title: String?,
    val publishedAt: String?,
    val url: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
