package com.trawlbens.reift.core.utils

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
}