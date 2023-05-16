package com.nasvalljohan.myapplication.api

import com.nasvalljohan.myapplication.ui.repository.model.Availability
import com.nasvalljohan.myapplication.ui.repository.model.Filter
import com.nasvalljohan.myapplication.ui.repository.model.Restaurants

interface RestaurantRepoInterface {
    suspend fun getRestaurants(): Restaurants

    suspend fun getFilters(id: String): Filter

    suspend fun getAvailability(id: String): Availability
}
