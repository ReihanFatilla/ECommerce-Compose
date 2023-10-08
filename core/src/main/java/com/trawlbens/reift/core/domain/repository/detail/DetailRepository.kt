package com.trawlbens.reift.core.domain.repository.detail

import com.trawlbens.reift.core.domain.model.Product

interface DetailRepository {
    suspend fun addToCartProduct(product: Product)
    suspend fun removeFromCartProduct(product: Product)
}