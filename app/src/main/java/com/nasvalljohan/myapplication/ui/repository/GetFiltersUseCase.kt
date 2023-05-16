package com.nasvalljohan.myapplication.ui.repository

import com.nasvalljohan.myapplication.api.RestaurantRepoInterface
import com.nasvalljohan.myapplication.ui.repository.model.Filter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetFiltersUseCase(
    private val repository: RestaurantRepoInterface,
) {
    operator fun invoke(id: String): Flow<Filter> = flow {
        try {
            val filters = repository.getFilters(id)
            emit(filters)
        } catch (e: HttpException) {
            println("Http exception: $e")
        } catch (e: IOException) {
            println("IO exception $e")
        }
    }
}
