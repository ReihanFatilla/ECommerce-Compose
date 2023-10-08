package com.trawlbens.reift.core.data.source.remote.api

import com.trawlbens.reift.core.data.source.remote.dto.ProductDTO
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class ProductApiImpl(val client: HttpClient):ProductApi {
    override suspend fun getProductByCategory(category: String): List<ProductDTO> {
        return client.get {
            url(ProductApi.GET_PRODUCT_URL(category))
        }
    }
}