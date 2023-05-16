package com.nasvalljohan.api

import com.nasvalljohan.repository.model.Restaurants

interface RestaurantApi {
    suspend fun getRestaurants(): Result<Restaurants>
    suspend fun getFilters(id: String): Result<Restaurants>
    suspend fun getOpenRestaurants(id: String): Result<Restaurants>
}
