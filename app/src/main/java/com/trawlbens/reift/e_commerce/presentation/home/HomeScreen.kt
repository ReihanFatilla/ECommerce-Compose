package com.trawlbens.reift.e_commerce.presentation.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.usecase.product.ProductUseCase
import com.trawlbens.reift.e_commerce.presentation.home.composables.HomeTopBar
import com.trawlbens.reift.e_commerce.presentation.common.ProductGrid
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalFoundationApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HomeTopBar(pagerState, navigator) {
                scope.launch { pagerState.animateScrollToPage(it) }
            }
        }
    ) { paddingValues ->
        HorizontalPager(
            modifier = Modifier.fillMaxSize().padding(paddingValues = paddingValues),
            state = pagerState,
            pageCount = 3
        ){ index ->
            val useCaseInstance: ProductUseCase = get()
            val viewModel: HomeViewModel = get { parametersOf(useCaseInstance) }
            viewModel.getProductByCategory(Product.Categories[index])
            ProductPager(navigator, viewModel)
        }
    }
}

@Composable
fun ProductPager(navigator: DestinationsNavigator, viewModel: HomeViewModel) {
    val listProduct by viewModel.listProductState.collectAsState()
    ProductGrid(
        listProduct = listProduct,
        navigator = navigator
    )
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
//    HomeScreen()
}