package com.example.clashofstatsapp.clanwarsleague.ui.leaguereward

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClanWarLeagueRewardArguments(
    val title: String,
    val id: Int,
): Parcelable