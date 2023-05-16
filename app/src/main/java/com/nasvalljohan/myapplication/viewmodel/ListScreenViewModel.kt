package com.nasvalljohan.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ListScreenViewModel : ViewModel() {

    var isPopUpOpen = mutableStateOf(false)
        private set

    fun handleEvents(event: ListScreenEvent) {
        when (event) {
            is ListScreenEvent.FilterEvent -> println(event.filterId)
            is ListScreenEvent.RestaurantSelectedEvent -> togglePopUp()
            ListScreenEvent.BackPress -> togglePopUp()
        }
    }

    private fun togglePopUp() {
        isPopUpOpen.value = !isPopUpOpen.value
    }
}
