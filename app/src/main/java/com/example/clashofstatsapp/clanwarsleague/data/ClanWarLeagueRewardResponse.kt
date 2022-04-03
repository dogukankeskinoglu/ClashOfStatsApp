package com.example.clashofstatsapp.clanwarsleague.data

import com.google.gson.annotations.SerializedName

data class ClanWarLeagueRewardResponse(
    @SerializedName("title") val title: String?,
    @SerializedName("reward") val reward: Int?,
)