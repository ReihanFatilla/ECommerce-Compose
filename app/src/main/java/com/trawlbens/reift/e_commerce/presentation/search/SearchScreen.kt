package com.trawlbens.reift.e_commerce.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.e_commerce.presentation.common.ProductGrid
import com.trawlbens.reift.e_commerce.presentation.search.composables.SearchBar

@Composable
fun SearchScreen(){
    val listProduct = Product.DUMMY
    var query by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.padding(horizontal = 16.dp),
        topBar = { SearchBar(query) { query = it } }
    ) { paddingValues ->
        ProductGrid(Modifier.padding(paddingValues = paddingValues), listProduct = listProduct)
    }
}

@Composable
@Preview(showBackground = true)
fun SearchScreenPreview(){
    SearchScreen()
}


