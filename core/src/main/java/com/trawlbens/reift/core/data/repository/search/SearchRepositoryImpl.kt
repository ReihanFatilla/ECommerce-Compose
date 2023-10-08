package com.trawlbens.reift.core.data.repository.search

import com.trawlbens.reift.core.data.source.remote.RemoteDataSource
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.search.SearchRepository
import com.trawlbens.reift.core.utils.DataMapper.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepositoryImpl(
    val remoteDataSource: RemoteDataSource,
): SearchRepository {
    override fun getAllProducts(): Flow<List<Product>> {
        return flow {
            val listProduct = remoteDataSource.getAllProduct().map { dto ->
                dto.toModel()
            }
            emit(listProduct)
        }
    }
}