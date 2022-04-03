package com.example.clashofstatsapp.clanwarsleague.ui

import com.example.clashofstatsapp.clanwarsleague.domain.ClanWarLeagueItem

sealed class ClansLeagueEvent {

    data class NavigateLeagueReward(val item: ClanWarLeagueItem) : ClansLeagueEvent()
}