package com.trawlbens.reift.core.domain.repository.cart

import com.trawlbens.reift.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCartProduct(): Flow<List<Product>>
}