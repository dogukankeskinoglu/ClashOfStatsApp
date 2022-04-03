package com.example.clashofstatsapp.clanwarsleague.data

import com.google.gson.annotations.SerializedName

data class ClanWarLeagueResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("text") val text: String?,
    @SerializedName("rewards") val rewards: List<ClanWarLeagueRewardResponse?>
)