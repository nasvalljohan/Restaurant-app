package com.nasvalljohan.myapplication.ui.repository.model

data class SelectedRestaurant(
    val filterIds: List<String>,
    val name: String,
    val is_currently_open: String,
    val image_url: String,
)
