package com.trawlbens.reift.core.data.source.remote.dto

data class ProductDTO(
    val image: String? = null,
    val price: Double? = null,
    val rating: RatingDTO? = null,
    val description: String? = null,
    val id: Int? = null,
    val title: String? = null,
    val category: String? = null
)

data class RatingDTO(
    val rate: Double? = null,
    val count: Int? = null
)
