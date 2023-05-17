package com.nasvalljohan.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasvalljohan.myapplication.Constants
import com.nasvalljohan.myapplication.ui.repository.GetAvailabilityUseCase
import com.nasvalljohan.myapplication.ui.repository.GetFiltersUseCase
import com.nasvalljohan.myapplication.ui.repository.GetRestaurantUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

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
            is ListScreenEvent.RestaurantSelectedEvent -> togglePopUp()
            ListScreenEvent.BackPress -> {
                togglePopUp()
                getRestaurants()
                getFilters()
            }
        }
    }

    private fun showFilteredList(event: ListScreenEvent.FilterEvent) {
        if (event.selectedButtonId == state.value.selectedButtonId) {
            state.value = state.value.copy(selectedButtonId = -1)
        } else {
            state.value = state.value.copy(selectedButtonId = event.selectedButtonId)
        }

        if (state.value.selectedButtonId == -1) {
            getRestaurantUseCase().onEach { result ->
                val updatedRestaurants = result.restaurants.toMutableList()
                state.value = state.value.copy(restaurants = updatedRestaurants)
            }.launchIn(viewModelScope)
        }

        if (event.selectedButtonId == state.value.selectedButtonId && event.filterId.isNotEmpty()) {
            val filteredList =
                state.value.restaurants.filter { it.filterIds.contains(event.filterId) }
                    .toMutableList()
            state.value = state.value.copy(restaurants = filteredList)
        }
        println(state.value.restaurants.size)
    }

    private fun togglePopUp() {
        state.value = ListScreenState(isPopUpOpen = !state.value.isPopUpOpen)
    }

    private fun getRestaurants() {
        getRestaurantUseCase().onEach { result ->
            val updatedRestaurants = result.restaurants.toMutableList()
            state.value = state.value.copy(restaurants = updatedRestaurants)
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

    private fun getAvailability() {
        viewModelScope.launch {
            TODO()
        }
    }
}
