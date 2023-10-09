package com.trawlbens.reift.core.data.repository.product

import android.util.Log
import com.trawlbens.reift.core.data.source.remote.RemoteDataSource
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.product.ProductRepository
import com.trawlbens.reift.core.utils.DataMapper.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl(
    val remoteDataSource: RemoteDataSource,
) : ProductRepository {
    override fun getProductByCategory(category: String): Flow<List<Product>> {
        return flow {
            try {
                val listProduct = remoteDataSource.getProductByCategory(category).map { it.toModel() }
                emit(listProduct)
            } catch (e: Exception) {
                Log.i("testing1", "berhasil masuk bawah: ${e.message}")
                throw e
            }
        }
    }



}