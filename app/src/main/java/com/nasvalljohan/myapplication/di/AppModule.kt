package com.nasvalljohan.myapplication.di

import com.nasvalljohan.myapplication.viewmodel.ListScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel { ListScreenViewModel() }
}
