package com.trawlbens.reift.core.data.source.remote.api

import com.trawlbens.reift.core.data.source.remote.dto.ProductDTO

interface ProductApi {
    companion object {
        private val BASE_URL = "https://fakestoreapi.com"
        val GET_PRODUCT_URL: (String) -> String = { "$BASE_URL/products/category/$it" }
    }
    suspend fun getProductByCategory(category: String): List<ProductDTO>
}