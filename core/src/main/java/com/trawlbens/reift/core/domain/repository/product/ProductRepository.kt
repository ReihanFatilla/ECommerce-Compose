package com.trawlbens.reift.core.domain.repository.product

import com.trawlbens.reift.core.domain.model.Product
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProductByCategory(category: String): Flowable<List<Product>>
    fun getCartProduct(): Flow<List<Product>>
}