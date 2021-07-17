package com.example.myspace.mapper

import com.example.myspace.data.dto.RateResponse
import com.example.myspace.data.entity.Rate


class RateResponseMapper : Mapper<RateResponse.RateResponseItem, Rate> {
    override fun map(from: RateResponse.RateResponseItem): Rate {
        return Rate(

            imageUrl = from.imageUrl.orEmpty(),
            newsSite = from.newsSite.orEmpty(),
            publishedAt = from.publishedAt.orEmpty(),
            title = from.title.orEmpty(),
            url = from.url.orEmpty()
        )
    }
}