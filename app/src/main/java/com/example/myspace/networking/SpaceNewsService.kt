package com.example.myspace.networking

import com.example.myspace.data.dto.RateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceNewsService {

    @GET("api/v2/articles")
    suspend fun loadRates(
        @Query("_limit")
        limit: Int,

        @Query("_sort")
        sort: String

    ): Response<List<RateResponse.RateResponseItem>>
}