package com.trawlbens.reift.core.data.repository.product

import com.trawlbens.reift.core.data.source.local.LocalDataSource
import com.trawlbens.reift.core.data.source.remote.RemoteDataSource
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.product.ProductRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource
): ProductRepository {
    override fun getProductByCategory(category: String): Flowable<List<Product>> {

    }

    override fun getCartProduct(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }
}