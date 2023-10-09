package com.trawlbens.reift.e_commerce.presentation.detail.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.e_commerce.presentation.detail.DetailViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailBottomBar(product: Product) {
    val viewModel = getViewModel<DetailViewModel>()
    viewModel.isProductOnCart(product.id)
    val isProductOnCart by viewModel.isProductOnCartState.collectAsState()
    Row(
        modifier = Modifier.padding(bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column {
            Text(
                text = "Price",
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Text(
                text = "$ " + product.price,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (isProductOnCart) {
                    viewModel.removeFromCartProduct(product)
                } else {
                    viewModel.addToCartProduct(product)
                }
            },
            border = if (!isProductOnCart) BorderStroke(1.dp, Color.Black) else null,
            colors = ButtonDefaults.buttonColors(containerColor = if (isProductOnCart) Color.White else Color.Black),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = if (isProductOnCart) "Remove From Cart" else "Add To Cart",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}