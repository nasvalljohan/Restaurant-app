package com.nasvalljohan.myapplication.ui.repository

import com.nasvalljohan.myapplication.api.RestaurantRepoInterface
import com.nasvalljohan.myapplication.ui.repository.model.Restaurants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetRestaurantUseCase(
    private val repository: RestaurantRepoInterface,
) {
    operator fun invoke(): Flow<Restaurants> = flow {
        try {
            val restaurants = repository.getRestaurants()
            emit(restaurants)
        } catch (e: HttpException) {
            println("Http exception: $e")
        } catch (e: IOException) {
            println("IO exception $e")
        }
    }
}
