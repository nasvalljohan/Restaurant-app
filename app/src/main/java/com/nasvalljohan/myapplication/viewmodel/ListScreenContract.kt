package com.nasvalljohan.myapplication.viewmodel

import com.nasvalljohan.myapplication.ui.repository.model.Availability
import com.nasvalljohan.myapplication.ui.repository.model.Filter
import com.nasvalljohan.myapplication.ui.repository.model.Restaurant
import com.nasvalljohan.myapplication.ui.repository.model.SelectedRestaurant

sealed interface ListScreenEvent {
    data class FilterEvent(val filterId: String, val selectedButtonId: Int) : ListScreenEvent
    data class RestaurantSelectedEvent(val selectedRestaurant: String) : ListScreenEvent
    object BackPress : ListScreenEvent
}

data class ListScreenState(
    val isPopUpOpen: Boolean = false,
    val restaurants: List<Restaurant> = emptyList(),
    val filters: List<Filter> = emptyList(),
    val restaurantList: MutableList<Restaurant> = mutableListOf(),
    val selectedButtonId: Int = -1,
    val selectedRestaurant: SelectedRestaurant? = null,
    val restaurantAvailability: Availability? = null,
)
