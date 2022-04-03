package com.example.clashofstatsapp.clanwarsleague.domain

import com.example.clashofstatsapp.clanwarsleague.data.ClanWarLeagueResponse
import com.example.clashofstatsapp.clanwarsleague.data.ClanWarLeagueRewardResponse
import com.example.clashofstatsapp.clanwarsleague.data.ClanWarLeaguesResponse
import com.example.clashofstatsapp.core.extension.orZero
import javax.inject.Inject

class ClanWarLeaguesMapper @Inject constructor() {

    fun mapFromResponse(response: ClanWarLeaguesResponse): List<ClanWarLeagueItem> {
        val items = response.warLeagues?.mapNotNull {
            mapClanLeagueItem(it)
        }.orEmpty()

        return items
    }

    private fun mapClanLeagueItem(response: ClanWarLeagueResponse?): ClanWarLeagueItem {
        return ClanWarLeagueItem(
            id = response?.id.orZero(),
            text = response?.text.orEmpty(),
            rewards = response?.rewards?.mapNotNull {
                mapClanLeagueReward(it)
            }.orEmpty()
        )
    }

    private fun mapClanLeagueReward(responseWar: ClanWarLeagueRewardResponse?): ClanWarLeagueRewardItem {
        return ClanWarLeagueRewardItem(
            title = responseWar?.title.orEmpty(),
            reward = responseWar?.reward.orZero()
        )
    }

}