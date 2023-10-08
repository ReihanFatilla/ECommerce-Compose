package com.trawlbens.reift.core.domain.usecase.detail

import com.trawlbens.reift.core.domain.model.Product

interface DetailUseCase {
    suspend fun addToCartProduct(product: Product)
    suspend fun removeFromCartProduct(product: Product)
}