package com.trawlbens.reift.e_commerce.presentation.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.e_commerce.presentation.cart.composables.CartTopBar
import com.trawlbens.reift.e_commerce.presentation.common.ProductGrid

@Composable
fun CartScreen(){
    val listProduct = Product.DUMMY
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CartTopBar() }
    ){ paddingValues ->
        ProductGrid(
            modifier = Modifier.padding(paddingValues),
            listProduct = listProduct,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CartScreenPreview() {
    CartScreen()
}