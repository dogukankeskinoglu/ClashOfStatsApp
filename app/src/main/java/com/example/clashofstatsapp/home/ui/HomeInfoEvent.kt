package com.example.clashofstatsapp.home.ui

sealed class HomeInfoEvent {

    object NavigateHomeVillage : HomeInfoEvent()
    object NavigateBuilderBaseVillage : HomeInfoEvent()
    data class NavigateClansLeague(val title: String) : HomeInfoEvent()
}