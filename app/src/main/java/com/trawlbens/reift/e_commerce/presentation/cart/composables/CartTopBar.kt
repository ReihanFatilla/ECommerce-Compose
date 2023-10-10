package com.trawlbens.reift.e_commerce.presentation.cart.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun CartTopBar(
    navigator: DestinationsNavigator,
){
    TopAppBar(
        modifier = Modifier.padding(horizontal = 16.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable {
                    navigator.popBackStack()
                },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back Button"
            )
        },
        title = { Text(text = "Your Cart", fontWeight = FontWeight.Bold) }
    )
}