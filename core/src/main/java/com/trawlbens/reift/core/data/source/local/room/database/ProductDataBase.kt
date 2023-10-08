package com.trawlbens.reift.core.data.source.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.trawlbens.reift.core.data.source.local.room.dao.ProductDAO
import com.trawlbens.reift.core.data.source.local.room.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class ProductDataBase: RoomDatabase() {
    abstract fun productDao(): ProductDAO
}