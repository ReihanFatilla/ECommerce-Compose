package com.trawlbens.reift.core.data.repository.detail

import com.trawlbens.reift.core.data.source.local.LocalDataSource
import com.trawlbens.reift.core.data.source.remote.RemoteDataSource
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.detail.DetailRepository
import com.trawlbens.reift.core.utils.DataMapper.toEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class DetailRepositoryImpl(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource
): DetailRepository {
    override fun addToCartProduct(product: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.insertCartProduct(product.toEntity())
        }
    }

    override fun removeFromCartProduct(product: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.deleteCartProduct(product.toEntity())
        }
    }

    override fun isProductOnCart(id: Int): Flow<Boolean> {
        return flow {
            localDataSource.getCartProductById(id).collect { entity ->
                emit(entity != null)
            }
        }
    }
}