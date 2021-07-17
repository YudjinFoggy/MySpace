package com.example.myspace.repository

import com.example.myspace.data.entity.Rate
import com.example.myspace.database.MyDatabase
import com.example.myspace.mapper.RateResponseMapper
import com.example.myspace.networking.SpaceNewsApi
import kotlinx.coroutines.*

class SpaceNewsRepository(database: MyDatabase) {

    private val dao = database.spaceDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val api = SpaceNewsApi.provideRetrofit()
    private val rateResponseMapper = RateResponseMapper()

    private suspend fun loadCurrency(limit: Int, sort: String): List<Rate> {
        val response = api.loadRates(limit, sort)

        return if (response.isSuccessful) {
            response.body()?.map {
                rateResponseMapper.map(it)
            }.orEmpty()
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }

    private suspend fun insert() {
        ioScope.launch {
            try {
                dao.insert(loadCurrency(30, "title"))
            } catch (e: Exception) {
                e.message
            }
        }
    }

    suspend fun loadAllNews(): List<Rate> {
        insert()
        delay(1000)
        return ioScope.async { dao.getAllNews() }.await()
    }
}