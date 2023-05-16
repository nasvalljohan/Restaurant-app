package com.nasvalljohan.myapplication.api

import com.nasvalljohan.myapplication.ui.repository.model.Availability
import com.nasvalljohan.myapplication.ui.repository.model.Filter
import com.nasvalljohan.myapplication.ui.repository.model.Restaurants

class RestaurantRepoImpl(
    private val api: RestaurantAPI,
) : RestaurantRepoInterface {
    override suspend fun getRestaurants(): Restaurants {
        return api.getRestaurants()
    }

    override suspend fun getFilters(id: String): Filter {
        return api.getFilters(id)
    }

    override suspend fun getAvailability(id: String): Availability {
        return api.getAvailability(id)
    }
}
