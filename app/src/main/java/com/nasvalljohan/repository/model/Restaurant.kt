package com.nasvalljohan.repository.model

import kotlinx.serialization.Serializable

@Serializable
data class Restaurant(
    val delivery_time_minutes: Int,
    val filterIds: List<String>,
    val id: String,
    val image_url: String,
    val name: String,
    val rating: Double,
)
