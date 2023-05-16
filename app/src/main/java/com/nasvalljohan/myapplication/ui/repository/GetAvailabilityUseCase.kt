package com.nasvalljohan.myapplication.ui.repository

import com.nasvalljohan.myapplication.api.RestaurantRepoInterface
import com.nasvalljohan.myapplication.ui.repository.model.Availability
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetAvailabilityUseCase(
    private val repository: RestaurantRepoInterface,
) {
    operator fun invoke(id: String): Flow<Availability> = flow {
        try {
            val availability = repository.getAvailability(id)
            emit(availability)
        } catch (e: HttpException) {
            println("Http exception: $e")
        } catch (e: IOException) {
            println("IO exception $e")
        }
    }
}
