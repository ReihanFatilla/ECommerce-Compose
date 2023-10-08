package com.trawlbens.reift.core.domain.repository.detail

import com.trawlbens.reift.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface DetailRepository {
    fun addToCartProduct(product: Product)
    fun removeFromCartProduct(product: Product)
    fun isProductOnCart(id: Int): Flow<Boolean>
}