package com.nasvalljohan.myapplication.api

import com.nasvalljohan.myapplication.ui.repository.model.Availability
import com.nasvalljohan.myapplication.ui.repository.model.Filter
import com.nasvalljohan.myapplication.ui.repository.model.Restaurants
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantAPI {

    @GET("v1/restaurants")
    suspend fun getRestaurants(): Restaurants

    @GET("v1/filter/{id}")
    suspend fun getFilters(@Path("id") id: String): Filter

    @GET("v1/open/{id}")
    suspend fun getAvailability(@Path("id") id: String): Availability
}
