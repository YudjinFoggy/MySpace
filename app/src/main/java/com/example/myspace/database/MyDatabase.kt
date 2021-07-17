package com.example.myspace.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myspace.data.entity.Rate
import com.example.myspace.database.dao.SpaceDao

@Database(entities = [Rate::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun spaceDao(): SpaceDao

    companion object {
        var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MyDatabase::class.java, "Database").build()
            }
            return INSTANCE as MyDatabase
        }
    }
}