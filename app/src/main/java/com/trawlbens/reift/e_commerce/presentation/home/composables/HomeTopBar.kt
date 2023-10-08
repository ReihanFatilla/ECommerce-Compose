package com.trawlbens.reift.e_commerce.presentation.home.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeTopBar() {
    TopAppBar(
        modifier = Modifier.padding(end = 16.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        title = { Text(text = "E-Commerce", fontWeight = FontWeight.Bold) },
        actions = {
            Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "shopping cart icon", tint = Color.Black)
        }
    )
}