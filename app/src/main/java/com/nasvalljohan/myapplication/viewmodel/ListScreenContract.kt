package com.nasvalljohan.myapplication.viewmodel

import com.nasvalljohan.myapplication.ui.repository.model.Filter
import com.nasvalljohan.myapplication.ui.repository.model.Restaurant

sealed interface ListScreenEvent {
    data class FilterEvent(val filterId: Int) : ListScreenEvent
    data class RestaurantSelectedEvent(val selectedRestaurant: Int) : ListScreenEvent
    object BackPress : ListScreenEvent
}

data class ListScreenState(
    val isPopUpOpen: Boolean = false,
    val restaurants: MutableList<Restaurant> = mutableListOf<Restaurant>(),
    val filters: List<Filter> = emptyList(),
    val isLoading: Boolean = true,
)
