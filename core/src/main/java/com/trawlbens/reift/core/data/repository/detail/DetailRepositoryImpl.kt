package com.trawlbens.reift.core.data.repository.detail

import com.trawlbens.reift.core.data.source.local.LocalDataSource
import com.trawlbens.reift.core.data.source.remote.RemoteDataSource
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.detail.DetailRepository

class DetailRepositoryImpl(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource
): DetailRepository {
    override suspend fun addToCartProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromCartProduct(product: Product) {
        TODO("Not yet implemented")
    }
}