package com.example.myspace.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myspace.data.entity.Rate

@Dao
interface SpaceDao {

    @Insert
    suspend fun insert(listSpaceNews: List<Rate>)

    @Query("SELECT * FROM space_table")
    suspend fun getAllNews(): List<Rate>
}