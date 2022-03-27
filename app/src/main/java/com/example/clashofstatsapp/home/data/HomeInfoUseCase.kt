package com.example.clashofstatsapp.home.data

import com.example.clashofstatsapp.core.parseFile
import com.example.clashofstatsapp.home.domain.HomeInfoItem
import com.example.clashofstatsapp.home.domain.HomeInfoResponseMapper

class HomeInfoUseCase {

    fun getHomeInfoItems(): List<HomeInfoItem> {
        val homeInfoResponse = parseFile<HomeInfoResponse>(fileName = HOME_INFO_PATH)
        val mapper = HomeInfoResponseMapper()
        return mapper.mapFromResponse(homeInfoResponse)
    }


    companion object {

        private const val HOME_INFO_PATH = "home/home_info_items.json"
    }
}