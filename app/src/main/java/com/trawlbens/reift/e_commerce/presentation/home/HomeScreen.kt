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
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.usecase.product.ProductUseCase
import com.trawlbens.reift.e_commerce.presentation.home.composables.HomeTopBar
import com.trawlbens.reift.e_commerce.presentation.common.ProductGrid
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HomeTopBar(pagerState) {
                scope.launch { pagerState.animateScrollToPage(it) }
            }
        }
    ) { paddingValues ->
        HorizontalPager(
            state = pagerState,
            pageCount = 4,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) { index ->
            val useCaseInstance: ProductUseCase = get()
            val viewModel: HomeViewModel = get { parametersOf(useCaseInstance) }
            viewModel.getProductByCategory(Product.Categories[index])
            ProductPager(viewModel)
        }
    }
}

@Composable
fun ProductPager(viewModel: HomeViewModel) {
    val listProduct by viewModel.listProductState.collectAsState()
    ProductGrid(
        listProduct = listProduct
    )
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}