package com.trawlbens.reift.core.utils

import com.trawlbens.reift.core.data.source.local.room.entity.ProductEntity
import com.trawlbens.reift.core.data.source.remote.dto.ProductDTO
import com.trawlbens.reift.core.domain.model.Product

object DataMapper {
    fun ProductDTO.toModel(): Product{
        return Product(
            id = id ?: 0,
            name = title.orEmpty(),
            price = (price ?: 0).toString(),
            description = description.orEmpty(),
            imageUrl = image.orEmpty(),
            rate = (rating?.rate ?: 0).toString(),
            rateCount = (rating?.count ?: 0).toString()
        )
    }
    fun Product.toEntity(): ProductEntity{
        return ProductEntity(
            id = id,
            name = name,
            price = price,
            description = description,
            imageUrl = imageUrl,
            rate = rate,
            rateCount = rateCount
        )
    }

    fun ProductEntity.toModel(): Product{
        return Product(
            id = id,
            name = name,
            price = price,
            description = description,
            imageUrl = imageUrl,
            rate = rate,
            rateCount = rateCount
        )
    }
}