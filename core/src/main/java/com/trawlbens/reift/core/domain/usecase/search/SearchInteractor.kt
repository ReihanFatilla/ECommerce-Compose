package com.trawlbens.reift.core.domain.usecase.search

import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.repository.search.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchInteractor(
    val searchRepository: SearchRepository
): SearchUseCase {
    override fun getAllProducts(): Flow<List<Product>> {
        return searchRepository.getAllProducts()
    }
}