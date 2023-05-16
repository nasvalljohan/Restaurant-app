package com.nasvalljohan.repository.model

import kotlinx.serialization.Serializable

@Serializable
data class Restaurants(
    val restaurants: List<Restaurant>,
)
