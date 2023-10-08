package com.trawlbens.reift.core.data.repository.search

import com.trawlbens.reift.core.data.source.remote.RemoteDataSource
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.search.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(
    val remoteDataSource: RemoteDataSource,
): SearchRepository {
    override fun getAllProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }
}