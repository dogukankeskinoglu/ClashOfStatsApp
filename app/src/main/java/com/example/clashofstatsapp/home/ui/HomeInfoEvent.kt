package com.example.clashofstatsapp.home.ui

import androidx.annotation.StringRes

sealed class HomeInfoEvent {

    object NavigateHomeVillage : HomeInfoEvent()
    object NavigateBuilderBaseVillage : HomeInfoEvent()
    data class ShowSnackBar(@StringRes val resource: Int) : HomeInfoEvent()
}