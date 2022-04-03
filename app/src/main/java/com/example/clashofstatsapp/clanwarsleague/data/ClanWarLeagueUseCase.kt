package com.example.clashofstatsapp.clanwarsleague.data

import com.example.clashofstatsapp.clanwarsleague.domain.ClanWarLeagueItem
import com.example.clashofstatsapp.clanwarsleague.domain.ClanWarLeaguesMapper
import com.example.clashofstatsapp.clanwarsleague.domain.ClanWarLeagueRewardItem
import com.example.clashofstatsapp.core.parseFile

class ClanWarLeagueUseCase {

    fun fetchClanWarLeagues(): List<ClanWarLeagueItem> {
        val clansLeagueResponse = parseFile<ClanWarLeaguesResponse>(fileName = CLANS_LEAGUE_PATH)
        val mapper = ClanWarLeaguesMapper()
        return mapper.mapFromResponse(clansLeagueResponse)
    }

    fun fetchClanWarLeagueWards(id: Int): List<ClanWarLeagueRewardItem> {
        val clansLeagueResponse = parseFile<ClanWarLeaguesResponse>(fileName = CLANS_LEAGUE_PATH)
        val mapper = ClanWarLeaguesMapper()
        val leagues = mapper.mapFromResponse(clansLeagueResponse)
        return leagues.first { it.id == id }.rewards
    }

    companion object {

        private const val CLANS_LEAGUE_PATH = "clans_league/clans_league_rewards.json"
    }
}