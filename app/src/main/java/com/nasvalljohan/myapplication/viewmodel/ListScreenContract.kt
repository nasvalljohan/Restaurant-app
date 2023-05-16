package com.nasvalljohan.myapplication.viewmodel

import com.nasvalljohan.myapplication.Constants.FILTERS
import com.nasvalljohan.myapplication.ui.repository.model.Restaurants

sealed interface ListScreenEvent {
    data class FilterEvent(val filterId: Int) : ListScreenEvent
    data class RestaurantSelectedEvent(val selectedRestaurant: Int) : ListScreenEvent
    object BackPress : ListScreenEvent
}

data class ListScreenState(
    val isPopUpOpen: Boolean = false,
    val restaurants: List<Restaurants> = emptyList(),
    val filters: List<String> = FILTERS,
)




