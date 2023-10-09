package com.trawlbens.reift.e_commerce.presentation.search.composables

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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.e_commerce.presentation.destinations.CartScreenDestination
import com.trawlbens.reift.e_commerce.presentation.destinations.SearchScreenDestination
import com.trawlbens.reift.e_commerce.utils.Extension.toWordCase

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchTopBar(navigator: DestinationsNavigator, query: String, onValueChange: (String) -> Unit) {
    Column {
        TopAppBar(navigator)
        SearchBar(query = query, onValueChange = onValueChange)
    }
}

@Composable
fun TopAppBar(navigator: DestinationsNavigator){
    TopAppBar(
        modifier = Modifier.padding(end = 20.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        title = { Text(text = "Search", fontWeight = FontWeight.Bold) },
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable {
                    navigator.popBackStack()
                },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back Button"
            )
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