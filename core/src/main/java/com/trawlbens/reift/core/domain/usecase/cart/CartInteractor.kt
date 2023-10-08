package com.trawlbens.reift.core.domain.usecase.cart

import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.cart.CartRepository
import kotlinx.coroutines.flow.Flow

class CartInteractor(val cartRepository: CartRepository): CartUseCase {
    override fun getCartProduct(): Flow<List<Product>> {
        return cartRepository.getCartProduct()
    }
}