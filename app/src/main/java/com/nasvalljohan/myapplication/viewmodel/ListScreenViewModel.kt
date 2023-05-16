package com.nasvalljohan.myapplication.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasvalljohan.myapplication.Constants
import com.nasvalljohan.myapplication.ui.repository.GetAvailabilityUseCase
import com.nasvalljohan.myapplication.ui.repository.GetFiltersUseCase
import com.nasvalljohan.myapplication.ui.repository.GetRestaurantUseCase
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class ListScreenViewModel(
    val getFiltersUseCase: GetFiltersUseCase,
    val getRestaurantUseCase: GetRestaurantUseCase,
    val getAvailabilityUseCase: GetAvailabilityUseCase,
) : ViewModel() {

    private val setState = mutableStateOf(ListScreenState())
    val state: State<ListScreenState> = setState

    init {
        getRestaurants()
        getFilters()
    }

    fun handleEvents(event: ListScreenEvent) {
        when (event) {
            is ListScreenEvent.FilterEvent -> println("tjena")
            is ListScreenEvent.RestaurantSelectedEvent -> togglePopUp()
            ListScreenEvent.BackPress -> togglePopUp()
        }
    }

    private fun togglePopUp() {
        setState.value = ListScreenState(isPopUpOpen = !setState.value.isPopUpOpen)
    }

    private fun getRestaurants() {
        viewModelScope.launch {
            val response = getRestaurantUseCase()
            setState.value = ListScreenState(restaurants = response.toList())
        }
    }

    private fun getFilters() {
        viewModelScope.launch {
            Constants.FILTERS.forEach {
                setState.value =
                    ListScreenState(filters = state.value.filters + getFiltersUseCase(it).toList())
            }
        }
    }

    private fun getAvailability() {
        viewModelScope.launch {
            TODO()
        }
    }
}
