package com.trawlbens.reift.core.domain.usecase.search

import com.trawlbens.reift.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface SearchUseCase {
    fun getAllProducts(): Flow<List<Product>>
}