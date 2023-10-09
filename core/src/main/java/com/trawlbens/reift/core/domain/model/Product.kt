package com.trawlbens.reift.core.domain.model

data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val description: String,
    val imageUrl: String,
    val rate: String,
    val rateCount: String
) {
    companion object{
        val DUMMY = List(5){
            Product(
                id = it,
                name = "Mens Casual Premium Slim Fit T-Shirts",
                price = "55.99",
                description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
                imageUrl = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
                rate = "4.1",
                rateCount = "259"
            )
        }
        val Categories = listOf(
            "electronics",
            "jewelery",
            "men's clothing",
            "women's clothing"
        )
    }
}
