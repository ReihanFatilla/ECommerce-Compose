package com.trawlbens.reift.core.data.repository.cart

import com.trawlbens.reift.core.data.source.local.LocalDataSource
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.cart.CartRepository
import com.trawlbens.reift.core.utils.DataMapper.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartRepositoryImpl(
    val localDataSource: LocalDataSource
): CartRepository {
    override fun getCartProduct(): Flow<List<Product>> {
        return localDataSource.getCartProductList().map { list ->
            list.map { entity ->
                entity.toModel()
            }
        }
    }
}