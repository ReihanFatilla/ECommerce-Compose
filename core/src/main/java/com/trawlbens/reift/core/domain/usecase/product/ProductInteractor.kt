package com.trawlbens.reift.core.domain.usecase.product

import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.product.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductInteractor(val productRepository: ProductRepository): ProductUseCase {
    override fun getProductByCategory(category: String): Flow<List<Product>> {
        return productRepository.getProductByCategory(category)
    }

    override fun getCartProduct(): Flow<List<Product>> {
        return productRepository.getCartProduct()
    }
}