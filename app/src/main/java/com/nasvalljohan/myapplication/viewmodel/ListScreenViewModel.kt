package com.nasvalljohan.myapplication.viewmodel

import androidx.lifecycle.ViewModel

class ListScreenViewModel() : ViewModel() {

    fun handleEvents(event: ListScreenEvent) {
        when (event) {
            is ListScreenEvent.FilterEvent -> {
                println(event.filterId)
            }
            is ListScreenEvent.RestaurantSelectedEvent -> println(event.selectedRestaurant)
        }
    }
}
