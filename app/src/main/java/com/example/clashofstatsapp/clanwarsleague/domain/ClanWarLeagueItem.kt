package com.example.clashofstatsapp.clanwarsleague.domain

data class ClanWarLeagueItem(
    val id: Int,
    val text: String,
    val rewards: List<ClanWarLeagueRewardItem>
)