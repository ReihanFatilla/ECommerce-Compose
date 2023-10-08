package com.trawlbens.reift.e_commerce.presentation.cart.composables

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
fun CartTopBar(){
    TopAppBar(
        modifier = Modifier.padding(end = 16.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        title = { Text(text = "Your Cart", fontWeight = FontWeight.Bold) }
    )
}