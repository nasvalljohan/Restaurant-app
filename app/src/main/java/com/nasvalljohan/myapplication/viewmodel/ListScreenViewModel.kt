package com.nasvalljohan.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasvalljohan.myapplication.Constants
import com.nasvalljohan.myapplication.ui.repository.GetAvailabilityUseCase
import com.nasvalljohan.myapplication.ui.repository.GetFiltersUseCase
import com.nasvalljohan.myapplication.ui.repository.GetRestaurantUseCase
import com.nasvalljohan.myapplication.ui.repository.model.SelectedRestaurant
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListScreenViewModel(
    private val getFiltersUseCase: GetFiltersUseCase,
    private val getRestaurantUseCase: GetRestaurantUseCase,
    private val getAvailabilityUseCase: GetAvailabilityUseCase,
) : ViewModel() {

    var state = mutableStateOf(ListScreenState())
        private set

    init {
        getRestaurants()
        getFilters()
    }

    fun handleEvents(event: ListScreenEvent) {
        when (event) {
            is ListScreenEvent.FilterEvent -> {
                showFilteredList(event)
            }
            is ListScreenEvent.RestaurantSelectedEvent -> {
                togglePopUp()
                showSelectedRestaurant(event)
                getAvailability(event.selectedRestaurant)
            }
            ListScreenEvent.BackPress -> {
                togglePopUp()
            }
        }
    }

    private fun togglePopUp() {
        state.value = state.value.copy(isPopUpOpen = !state.value.isPopUpOpen)
    }

    private fun showFilteredList(event: ListScreenEvent.FilterEvent) {
        if (event.selectedButtonId == state.value.selectedButtonId) {
            state.value = state.value.copy(selectedButtonId = -1)
        } else {
            state.value = state.value.copy(selectedButtonId = event.selectedButtonId)
        }

        if (state.value.selectedButtonId == -1) {
            getRestaurants()
        }

        if (event.selectedButtonId == state.value.selectedButtonId && event.filterId.isNotEmpty()) {
            val filteredList =
                state.value.restaurants.filter { it.filterIds.contains(event.filterId) }
                    .toMutableList()
            state.value = state.value.copy(restaurantList = filteredList)
        }
    }

    private fun showSelectedRestaurant(event: ListScreenEvent.RestaurantSelectedEvent) {
        state.value.restaurants.forEach {
            if (it.id == event.selectedRestaurant) {
                state.value = state.value.copy(
                    selectedRestaurant = SelectedRestaurant(
                        it.filterIds,
                        it.name,
                        if (state.value.restaurantAvailability?.is_currently_open == true) {
                            "Open"
                        } else {
                            "Closed"
                        },
                        it.image_url,
                    ),
                )
            }
        }
    }

    private fun getAvailability(id: String) {
        getAvailabilityUseCase(id).onEach {
            val updatedAvailability = state.value.restaurantAvailability
            state.value = state.value.copy(restaurantAvailability = updatedAvailability)
        }.launchIn(viewModelScope)
    }

    private fun getRestaurants() {
        getRestaurantUseCase().onEach { result ->
            val updatedRestaurants = result.restaurants.toMutableList()
            state.value = state.value.copy(
                restaurants = updatedRestaurants,
                restaurantList = updatedRestaurants,
            )
        }.launchIn(viewModelScope)
    }

    private fun getFilters() {
        for (i in Constants.FILTERS) {
            getFiltersUseCase(i).onEach { filter ->
                val updatedFilters = state.value.filters.toMutableList()
                updatedFilters.add(filter)

                state.value = state.value.copy(filters = updatedFilters)
            }.launchIn(viewModelScope)
        }
    }
}
