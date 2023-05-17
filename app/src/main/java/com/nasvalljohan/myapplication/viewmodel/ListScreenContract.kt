package com.nasvalljohan.myapplication.viewmodel

import com.nasvalljohan.myapplication.ui.repository.model.Filter
import com.nasvalljohan.myapplication.ui.repository.model.Restaurant

sealed interface ListScreenEvent {
    data class FilterEvent(val filterId: String, val selectedButtonId: Int) : ListScreenEvent
    data class RestaurantSelectedEvent(val selectedRestaurant: Int) : ListScreenEvent
    object BackPress : ListScreenEvent
}

data class ListScreenState(
    val isFilterActive: Boolean = false,
    val isPopUpOpen: Boolean = false,
    val restaurants: MutableList<Restaurant> = mutableListOf(),
    val filters: MutableList<Filter> = mutableListOf(),
    val filteredList: MutableList<Restaurant> = mutableListOf(),
    var selectedButtonId: Int = -1,
)
