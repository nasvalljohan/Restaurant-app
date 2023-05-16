package com.nasvalljohan.myapplication.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private val _state = mutableStateOf(ListScreenState())
    val state: State<ListScreenState> = _state

    init {
        getRestaurants()
    }

    var isPopUpOpen = mutableStateOf(false)
        private set

    fun handleEvents(event: ListScreenEvent) {
        when (event) {
            is ListScreenEvent.FilterEvent -> println(state.value.restaurants)
            is ListScreenEvent.RestaurantSelectedEvent -> togglePopUp()
            ListScreenEvent.BackPress -> togglePopUp()
        }
    }

    private fun togglePopUp() {
        isPopUpOpen.value = !isPopUpOpen.value
    }

    private fun getRestaurants() {
        viewModelScope.launch {
            val response = getRestaurantUseCase()
            _state.value = ListScreenState(restaurants = response.toList())
        }
    }
}
