package com.trawlbens.reift.core.data.source.local.room.entity

import androidx.room.Entity

@Entity
data class ProductEntity(
    val id: Int,
    val name: String,
    val price: String,
    val description: String,
    val imageUrl: String,
    val rate: String,
    val rateCount: String
)
