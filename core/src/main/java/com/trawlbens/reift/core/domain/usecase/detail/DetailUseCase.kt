package com.trawlbens.reift.core.domain.usecase.detail

import com.trawlbens.reift.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface DetailUseCase {
    fun addToCartProduct(product: Product)
    fun removeFromCartProduct(product: Product)
    fun isProductOnCart(id: Int): Flow<Boolean>
}