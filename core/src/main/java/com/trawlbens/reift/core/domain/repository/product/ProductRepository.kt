package com.trawlbens.reift.core.domain.repository.product

import com.trawlbens.reift.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProductByCategory(category: String): Flow<List<Product>>
}