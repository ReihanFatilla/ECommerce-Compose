package com.trawlbens.reift.core.domain.repository.search

import com.trawlbens.reift.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun getAllProducts(): Flow<List<Product>>
}