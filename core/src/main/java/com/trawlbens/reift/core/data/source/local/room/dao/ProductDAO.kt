package com.trawlbens.reift.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.trawlbens.reift.core.data.source.local.room.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDAO {
    @Query("SELECT * FROM ProductEntity")
    fun getCartProductList(): Flow<List<ProductEntity>>
    @Query("SELECT * FROM ProductEntity WHERE id LIKE :id")
    fun getCartProductById(id: Int): Flow<ProductEntity?>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartProduct(productEntity: ProductEntity)
    @Delete
    suspend fun deleteCartProduct(productEntity: ProductEntity)
}