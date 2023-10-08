package com.trawlbens.reift.core.domain.usecase.product

import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.product.ProductRepository
import io.reactivex.rxjava3.core.Flowable

class ProductInteractor(val productRepository: ProductRepository): ProductUseCase {
    override fun getProductByCategory(category: String): Flowable<List<Product>> {
        return productRepository.getProductByCategory(category)
    }

    override fun getCartProduct(): Flowable<List<Product>> {
        return productRepository.getCartProduct()
    }
}