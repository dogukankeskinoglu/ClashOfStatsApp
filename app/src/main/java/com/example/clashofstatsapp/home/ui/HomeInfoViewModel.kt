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

    private val usecase: HomeInfoUseCase = HomeInfoUseCase()


    fun getHomeInfoItems(): List<HomeInfoItem> {
        return usecase.getHomeInfoItems()
    }



    fun onItemClickListener(id: Int) {
        viewModelScope.launch {
            when(id) {
                0 -> eventChannel.send(HomeInfoEvent.NavigateHomeVillage)
                1 -> eventChannel.send(HomeInfoEvent.NavigateBuilderBaseVillage)
                2 -> eventChannel.send(HomeInfoEvent.ShowSnackBar(R.string.in_progress))
            }
        }
    }
}