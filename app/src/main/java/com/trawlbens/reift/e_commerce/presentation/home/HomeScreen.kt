package com.trawlbens.reift.e_commerce.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.e_commerce.presentation.home.composables.HomeTopBar
import com.trawlbens.reift.e_commerce.presentation.common.ProductGrid
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val listProduct = Product.DUMMY
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { HomeTopBar(pagerState){
            scope.launch { pagerState.animateScrollToPage(it) }
        } }
    ){ paddingValues ->
        HorizontalPager(
            state = pagerState,
            pageCount = 4,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) { index ->
            ProductGrid(
                listProduct = listProduct,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}