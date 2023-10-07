package com.trawlbens.reift.core.domain.usecase.product

import com.trawlbens.reift.core.domain.repository.product.ProductRepository

class ProductInteractor(val productRepository: ProductRepository): ProductUseCase {
}