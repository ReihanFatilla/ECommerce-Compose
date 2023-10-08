package com.trawlbens.reift.core.domain.usecase.product

import com.trawlbens.reift.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductUseCase {
    fun getProductByCategory(category: String): Flow<List<Product>>


}