package com.trawlbens.reift.core.domain.usecase.cart

import com.trawlbens.reift.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface CartUseCase {
    fun getCartProduct(): Flow<List<Product>>
}