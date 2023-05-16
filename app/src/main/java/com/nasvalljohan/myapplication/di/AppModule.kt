package com.nasvalljohan.myapplication.di

import com.nasvalljohan.api.RestaurantApi
import com.nasvalljohan.api.RestaurantApiImpl
import com.nasvalljohan.api.ktorHttpClient
import com.nasvalljohan.myapplication.viewmodel.ListScreenViewModel
import com.nasvalljohan.repository.RestaurantRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    single { ktorHttpClient }

    single<RestaurantApi> { RestaurantApiImpl(get()) }
    single { RestaurantRepository(get()) }
    viewModel { ListScreenViewModel(get()) }
}
