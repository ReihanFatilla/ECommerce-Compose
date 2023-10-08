package com.trawlbens.reift.core.domain.usecase.detail

import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.detail.DetailRepository
import kotlinx.coroutines.flow.Flow

class DetailInteractor(val detailRepository: DetailRepository): DetailUseCase {
    override fun addToCartProduct(product: Product) {
        detailRepository.addToCartProduct(product)
    }

    override fun removeFromCartProduct(product: Product) {
        detailRepository.removeFromCartProduct(product)
    }

    override fun isProductOnCart(id: Int): Flow<Boolean> {
        return detailRepository.isProductOnCart(id)
    }
}