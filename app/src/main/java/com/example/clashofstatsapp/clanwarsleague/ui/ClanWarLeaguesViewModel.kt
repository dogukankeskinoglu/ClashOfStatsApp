package com.example.clashofstatsapp.clanwarsleague.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clashofstatsapp.clanwarsleague.data.ClanWarLeagueUseCase
import com.example.clashofstatsapp.clanwarsleague.domain.ClanWarLeagueItem
import com.example.clashofstatsapp.clanwarsleague.domain.ClanWarLeagueRewardItem
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ClanWarLeaguesViewModel : ViewModel() {

    private val eventChannel = Channel<ClansLeagueEvent>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    private val useCase: ClanWarLeagueUseCase = ClanWarLeagueUseCase()

    fun fetchClanWarLeagues(): List<ClanWarLeagueItem> {
        return useCase.fetchClanWarLeagues()
    }

    fun fetchClanWarLeaguesReward(id: Int): List<ClanWarLeagueRewardItem> {
        return useCase.fetchClanWarLeagueWards(id)
    }

    fun onItemClickListener(item: ClanWarLeagueItem) {
        viewModelScope.launch {
            eventChannel.send(ClansLeagueEvent.NavigateLeagueReward(item))
        }
    }
}