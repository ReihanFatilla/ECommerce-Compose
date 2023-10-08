package com.trawlbens.reift.core.domain.usecase.detail

import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.detail.DetailRepository

class DetailInteractor(val detailRepository: DetailRepository): DetailUseCase {
    override suspend fun addToCartProduct(product: Product) {
        detailRepository.addToCartProduct(product)
    }

    override suspend fun removeFromCartProduct(product: Product) {
        detailRepository.removeFromCartProduct(product)
    }
}