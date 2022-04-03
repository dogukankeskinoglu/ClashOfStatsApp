package com.example.clashofstatsapp.clanwarsleague.data

import com.google.gson.annotations.SerializedName

data class ClanWarLeaguesResponse(
    @SerializedName("leagues") val warLeagues: List<ClanWarLeagueResponse?>?
)