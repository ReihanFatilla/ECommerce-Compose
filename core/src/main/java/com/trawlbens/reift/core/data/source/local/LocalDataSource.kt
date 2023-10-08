package com.trawlbens.reift.core.data.source.local

import com.trawlbens.reift.core.data.source.local.room.dao.ProductDAO
import com.trawlbens.reift.core.data.source.local.room.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    val productDAO: ProductDAO,
) {
    fun getCartProductList(): Flow<List<ProductEntity>> {
        return productDAO.getCartProductList()
    }

    fun getCartProductById(id: Int): Flow<ProductEntity?>{
        return productDAO.getCartProductById(id)
    }

    suspend fun insertCartProduct(productEntity: ProductEntity){
        productDAO.insertCartProduct(productEntity)
    }

    suspend fun deleteCartProduct(productEntity: ProductEntity){
        productDAO.deleteCartProduct(productEntity)
    }
}