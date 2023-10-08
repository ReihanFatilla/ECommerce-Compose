package com.trawlbens.reift.e_commerce.presentation.detail.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailTopBar() {
    TopAppBar(
        title = { Text(text = "Product Detail") },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back Button"
            )
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}

@Composable
@Preview(showBackground = true)
fun DetailTopBarPreview(){
    DetailTopBar()
}