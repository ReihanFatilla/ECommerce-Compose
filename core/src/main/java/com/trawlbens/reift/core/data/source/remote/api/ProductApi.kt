package com.trawlbens.reift.core.data.source.remote.api

import com.trawlbens.reift.core.data.source.remote.dto.ProductDTO

interface ProductApi {
    companion object {
        private val BASE_URL = "https://fakestoreapi.com"
        val GET_PRODUCT_URL: (String) -> String = { "$BASE_URL/products/category/$it" }
        val GET_ALL_PRODUCT_URL = "$BASE_URL/products"
    }
    suspend fun getProductByCategory(category: String): List<ProductDTO>
    suspend fun getAllProduct(): List<ProductDTO>
}