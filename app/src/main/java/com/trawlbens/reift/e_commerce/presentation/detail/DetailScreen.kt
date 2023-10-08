package com.trawlbens.reift.e_commerce.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
                    .aspectRatio(1.7f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFE9E9E9))
                    .padding(all = 12.dp),
                painter = rememberAsyncImagePainter(model = product.imageUrl),
                contentDescription = product.name + " Image",
            )
        }
    }
}

@Composable
fun DetailBottomBar(product: Product) {
    Row(
        modifier = Modifier.padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column{
            Text(text = "Price", color = Color.Gray, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            Text(text = "$ "+product.price.toString(), color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }
        Button(modifier = Modifier.fillMaxWidth(),onClick = {  }, colors = ButtonDefaults.buttonColors(containerColor = Color.Black), shape = RoundedCornerShape(10.dp)) {
            Text(text = "Add To Cart", fontWeight = FontWeight.Bold, fontSize = 22.sp)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen(product = Product.DUMMY.random())
}
