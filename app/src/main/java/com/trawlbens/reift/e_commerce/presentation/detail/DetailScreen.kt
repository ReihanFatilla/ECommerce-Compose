package com.trawlbens.reift.e_commerce.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.e_commerce.presentation.detail.composables.DetailBottomBar
import com.trawlbens.reift.e_commerce.presentation.detail.composables.DetailProductText
import com.trawlbens.reift.e_commerce.presentation.detail.composables.DetailTopBar

@Composable
fun DetailScreen(
    product: Product,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        topBar = { DetailTopBar() },
        bottomBar = { DetailBottomBar(product = product) }
    ) { paddingValues ->
        Column(
            Modifier.padding(paddingValues)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFE9E9E9))
                    .padding(all = 12.dp),
                painter = rememberAsyncImagePainter(model = product.imageUrl),
                contentDescription = product.name + " Image",
            )
            Spacer(modifier = Modifier.height(16.dp))
            DetailProductText(product = product)
        }
    }
}



@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen(product = Product.DUMMY.random())
}
