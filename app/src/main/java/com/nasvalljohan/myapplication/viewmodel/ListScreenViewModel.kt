package com.nasvalljohan.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasvalljohan.repository.RestaurantRepository
import kotlinx.coroutines.launch

class ListScreenViewModel(
    private val repo: RestaurantRepository,
) : ViewModel() {

    fun handleEvents(event: ListScreenEvent) {
        when (event) {
            is ListScreenEvent.FilterEvent -> {
                println(event.filterId)
                getShit()
            }
            is ListScreenEvent.RestaurantSelectedEvent -> println(event.selectedRestaurant)
        }
    }

    fun getShit() {
        viewModelScope.launch {
            val response = repo.getRestaurants().getOrNull()
            println(response)
        }
    }
}
