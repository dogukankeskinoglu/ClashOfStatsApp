package com.example.clashofstatsapp.home.data

import com.example.clashofstatsapp.core.parseFile
import com.example.clashofstatsapp.home.domain.HomeInfoItem
import com.example.clashofstatsapp.home.domain.HomeInfoResponseMapper
import javax.inject.Inject

class HomeInfoUseCase @Inject constructor(
    private val mapper: HomeInfoResponseMapper
) {

    fun getHomeInfoItems(): List<HomeInfoItem> {
        val homeInfoResponse = parseFile<HomeInfoResponse>(fileName = HOME_INFO_PATH)
        return mapper.mapFromResponse(homeInfoResponse)
    }

    companion object {

        private const val HOME_INFO_PATH = "home/home_info_items.json"
    }
}