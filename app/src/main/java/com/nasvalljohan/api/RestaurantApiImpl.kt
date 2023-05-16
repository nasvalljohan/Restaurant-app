package com.nasvalljohan.api

import com.nasvalljohan.repository.model.Restaurants
import io.ktor.client.* // ktlint-disable no-wildcard-imports
import io.ktor.client.call.* // ktlint-disable no-wildcard-imports
import io.ktor.client.request.* // ktlint-disable no-wildcard-imports
import io.ktor.http.*

class RestaurantApiImpl(
    private val client: HttpClient,
    private val base: String = "https://food-delivery.umain.io/api/v1",
) : RestaurantApi {

    override suspend fun getRestaurants(): Result<Restaurants> {
        val response = client.get("$base/restaurants") {
            accept(ContentType.Application.Json)
        }
        return response.body()
    }

    override suspend fun getFilters(id: String): Result<Restaurants> {
        return try {
            val response = client.get("$base/filter/$id")
            val restaurants = response.body<Restaurants>()
            Result.success(restaurants)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getOpenRestaurants(id: String): Result<Restaurants> {
        return try {
            val response = client.get("$base/open/$id")
            val restaurants = response.body<Restaurants>()
            Result.success(restaurants)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
