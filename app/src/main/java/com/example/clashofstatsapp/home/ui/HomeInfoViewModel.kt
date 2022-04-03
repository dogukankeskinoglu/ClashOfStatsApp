package com.example.clashofstatsapp.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clashofstatsapp.R
import com.example.clashofstatsapp.home.data.HomeInfoUseCase
import com.example.clashofstatsapp.home.domain.HomeInfoItem
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeInfoViewModel : ViewModel() {

    private val eventChannel = Channel<HomeInfoEvent>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    private val useCase: HomeInfoUseCase = HomeInfoUseCase()

    fun getHomeInfoItems(): List<HomeInfoItem> {
        return useCase.getHomeInfoItems()
    }

    fun onItemClickListener(item: HomeInfoItem) {
        viewModelScope.launch {
            when (item.id) {
                1 -> eventChannel.send(HomeInfoEvent.NavigateHomeVillage)
                2 -> eventChannel.send(HomeInfoEvent.NavigateBuilderBaseVillage)
                3 -> eventChannel.send(HomeInfoEvent.NavigateClansLeague(item.text))
            }
        }
    }
}