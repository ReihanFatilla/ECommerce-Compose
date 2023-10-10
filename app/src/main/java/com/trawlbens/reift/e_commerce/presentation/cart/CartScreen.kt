package com.trawlbens.reift.e_commerce.presentation.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.trawlbens.reift.e_commerce.presentation.cart.composables.CartTopBar
import com.trawlbens.reift.e_commerce.presentation.common.ProductGrid
import org.koin.androidx.compose.getViewModel

@Destination
@Composable
fun CartScreen(
    navigator: DestinationsNavigator,
){
    val viewModel = getViewModel<CartViewModel>()
    val listCartProductState by viewModel.listCartProductState.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CartTopBar(navigator = navigator) }
    ){ paddingValues ->
        ProductGrid(
            modifier = Modifier.padding(paddingValues),
            navigator = navigator,
            listProduct = listCartProductState
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CartScreenPreview() {
//    CartScreen()
}