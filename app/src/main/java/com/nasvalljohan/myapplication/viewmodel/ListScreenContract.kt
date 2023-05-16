package com.nasvalljohan.myapplication.viewmodel // ktlint-disable filename

sealed interface ListScreenEvent {
    data class FilterEvent(val filterId: Int) : ListScreenEvent
    data class RestaurantSelectedEvent(val selectedRestaurant: Int) : ListScreenEvent
    object BackPress : ListScreenEvent
}
