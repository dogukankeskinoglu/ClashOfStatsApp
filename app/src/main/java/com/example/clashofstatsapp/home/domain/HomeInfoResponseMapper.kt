package com.example.clashofstatsapp.home.domain

import com.example.clashofstatsapp.core.extension.orZero
import com.example.clashofstatsapp.home.data.HomeInfoItemResponse
import com.example.clashofstatsapp.home.data.HomeInfoResponse

class HomeInfoResponseMapper {

    fun mapFromResponse(response: HomeInfoResponse): List<HomeInfoItem> {
        val items = response.levels?.mapNotNull {
            mapHomeItemInfoResponse(it)
        }.orEmpty()

        return items
    }

    private fun mapHomeItemInfoResponse(response: HomeInfoItemResponse?): HomeInfoItem {
        return HomeInfoItem(
            id = response?.id.orZero(),
            text = response?.text.orEmpty()
        )
    }

}