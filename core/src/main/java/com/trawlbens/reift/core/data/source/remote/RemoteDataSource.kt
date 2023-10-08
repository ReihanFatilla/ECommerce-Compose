package com.trawlbens.reift.core.data.source.remote

import com.trawlbens.reift.core.data.source.remote.api.ProductApi
import com.trawlbens.reift.core.data.source.remote.dto.ProductDTO

class RemoteDataSource(
    val productApi: ProductApi
) {
    suspend fun getProductByCategory(category: String): List<ProductDTO> {
        return productApi.getProductByCategory(category)
    }
}