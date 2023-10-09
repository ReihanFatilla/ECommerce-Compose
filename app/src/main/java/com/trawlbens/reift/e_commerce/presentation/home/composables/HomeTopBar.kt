package com.trawlbens.reift.e_commerce.presentation.home.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.e_commerce.presentation.cart.CartScreen
import com.trawlbens.reift.e_commerce.presentation.destinations.CartScreenDestination
import com.trawlbens.reift.e_commerce.presentation.destinations.SearchScreenDestination
import com.trawlbens.reift.e_commerce.presentation.search.SearchScreen
import com.trawlbens.reift.e_commerce.utils.Extension.toWordCase

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeTopBar(pagerState: PagerState, navigator: DestinationsNavigator, onTabClick: (Int) -> Unit) {
    Column {
        TopAppBar(navigator)
        CategoryTabRow(pagerState = pagerState, onTabClick = onTabClick)
    }
}

@Composable
fun TopAppBar(navigator: DestinationsNavigator){
    TopAppBar(
        modifier = Modifier.padding(end = 20.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        title = { Text(text = "E-Commerce", fontWeight = FontWeight.Bold) },
        actions = {
            Icon(modifier = Modifier.clickable {
                navigator.navigate(SearchScreenDestination)
            },imageVector = Icons.Outlined.Search, contentDescription = "Search icon", tint = Color.Black)
            Spacer(modifier = Modifier.width(20.dp))
            Icon(modifier = Modifier.clickable {
                navigator.navigate(CartScreenDestination)
            },imageVector = Icons.Outlined.ShoppingCart, contentDescription = "shopping cart icon", tint = Color.Black)
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryTabRow(pagerState: PagerState, onTabClick: (Int) -> Unit){
    ScrollableTabRow(selectedTabIndex = pagerState.currentPage, edgePadding = 16.dp, indicator = {}) {
        Product.Categories.map { it.toWordCase() }.forEachIndexed { index, text ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    onTabClick(index)
                },
                text = {
                    Text(text = text)
                },
            )
        }
    }
}