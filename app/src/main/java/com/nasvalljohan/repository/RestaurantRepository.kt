package com.nasvalljohan.repository

import com.nasvalljohan.api.RestaurantApi
import com.nasvalljohan.repository.model.Restaurants

class RestaurantRepository(private val api: RestaurantApi) {
    suspend fun getRestaurants(): Result<Restaurants> {
        println(api.getRestaurants())
        return api.getRestaurants()
    }

    suspend fun getFilteredList(id: String): Result<Restaurants> {
        return api.getFilters(id = id)
    }

    suspend fun getOpenRestaurants(id: String): Result<Restaurants> {
        return api.getOpenRestaurants(id)
    }
}
