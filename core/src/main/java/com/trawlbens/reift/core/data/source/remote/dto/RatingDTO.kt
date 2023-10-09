package com.trawlbens.reift.core.data.source.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RatingDTO(
    val rate: Double? = null,
    val count: Int? = null
)
