package com.trawlbens.reift.core.data.repository.product

import com.trawlbens.reift.core.data.source.local.LocalDataSource
import com.trawlbens.reift.core.data.source.remote.RemoteDataSource
import com.trawlbens.reift.core.data.source.remote.dto.ProductDTO
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.product.ProductRepository
import com.trawlbens.reift.core.utils.DataMapper.toModel
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource
): ProductRepository {
    override fun getProductByCategory(category: String): Flow<List<Product>> {
        return flow {
            val listProduct = remoteDataSource.getProductByCategory(category).map { it.toModel() }
            emit(listProduct)
        }
    }

    override fun getCartProduct(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }
}