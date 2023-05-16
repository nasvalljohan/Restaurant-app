package com.nasvalljohan.myapplication.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasvalljohan.myapplication.Constants
import com.nasvalljohan.myapplication.ui.repository.GetAvailabilityUseCase
import com.nasvalljohan.myapplication.ui.repository.GetFiltersUseCase
import com.nasvalljohan.myapplication.ui.repository.GetRestaurantUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class ListScreenViewModel(
    private val getFiltersUseCase: GetFiltersUseCase,
    private val getRestaurantUseCase: GetRestaurantUseCase,
    private val getAvailabilityUseCase: GetAvailabilityUseCase,
) : ViewModel() {

    private val setState = mutableStateOf(ListScreenState())
    val state: State<ListScreenState> = setState

    init {
        getRestaurants()
    }

    fun handleEvents(event: ListScreenEvent) {
        when (event) {
            is ListScreenEvent.FilterEvent -> println(state.value.restaurants.size)
            is ListScreenEvent.RestaurantSelectedEvent -> togglePopUp()
            ListScreenEvent.BackPress -> {
                getRestaurants()
                togglePopUp()
            }
        }
    }

    private fun togglePopUp() {
        setState.value = ListScreenState(isPopUpOpen = !state.value.isPopUpOpen)
    }

    private fun getRestaurants() {
        setState.value = ListScreenState(isLoading = true)
        getRestaurantUseCase().onEach {
            setState.value = ListScreenState(restaurants = it.restaurants.toMutableList())
        }.launchIn(viewModelScope)
    }

    private fun getFilters() {
        viewModelScope.launch {
            Constants.FILTERS.forEach {
                setState.value =
                    ListScreenState(
                        filters = state.value.filters + getFiltersUseCase(it).toList(),
                        restaurants = state.value.restaurants,
                    )
            }
        }
    }

    private fun getAvailability() {
        viewModelScope.launch {
            TODO()
        }
    }
}
