package com.nasvalljohan.myapplication.di

import com.nasvalljohan.myapplication.Constants.BASE_URL
import com.nasvalljohan.myapplication.api.RestaurantAPI
import com.nasvalljohan.myapplication.api.RestaurantRepoImpl
import com.nasvalljohan.myapplication.api.RestaurantRepoInterface
import com.nasvalljohan.myapplication.ui.repository.GetAvailabilityUseCase
import com.nasvalljohan.myapplication.ui.repository.GetFiltersUseCase
import com.nasvalljohan.myapplication.ui.repository.GetRestaurantUseCase
import com.nasvalljohan.myapplication.viewmodel.ListScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val AppModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestaurantAPI::class.java)
    }

    single<RestaurantRepoInterface> { RestaurantRepoImpl(get()) }

    single { GetRestaurantUseCase(get()) }

    single { GetAvailabilityUseCase(get()) }

    single { GetFiltersUseCase(get()) }

    viewModel { ListScreenViewModel(get(), get(), get()) }
}
