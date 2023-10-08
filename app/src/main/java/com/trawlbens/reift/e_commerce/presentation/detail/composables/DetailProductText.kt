package com.trawlbens.reift.e_commerce.presentation.detail.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trawlbens.reift.core.domain.model.Product

@Composable
fun DetailProductText(product: Product) {
    Text(
        text = product.name,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 17.sp
    )
    Spacer(modifier = Modifier.height(4.dp))
    DetailRatingSection(product = product)
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Description",
        fontSize = 16.sp,
        color = Color.Black,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = product.description,
        fontSize = 14.sp,
        color = Color.Gray,
        fontWeight = FontWeight.Medium
    )
}