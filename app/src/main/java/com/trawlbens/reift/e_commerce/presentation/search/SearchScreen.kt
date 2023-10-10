package com.trawlbens.reift.e_commerce.presentation.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.trawlbens.reift.e_commerce.presentation.common.ProductGrid
import com.trawlbens.reift.e_commerce.presentation.search.composables.SearchTopBar
import org.koin.androidx.compose.getViewModel

@Destination
@Composable
fun SearchScreen(
    navigator: DestinationsNavigator,
) {
    val viewModel = getViewModel<SearchViewModel>()
    val listSearchedProductState by viewModel.listSearchedProductState.collectAsState()
    Scaffold(
        modifier = Modifier.padding(horizontal = 16.dp),
        topBar = { SearchTopBar(navigator = navigator) }
    ) { paddingValues ->
        ProductGrid(
            modifier = Modifier.padding(paddingValues = paddingValues),
            navigator = navigator,
            listProduct = listSearchedProductState
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SearchScreenPreview() {
//    SearchScreen()
}


