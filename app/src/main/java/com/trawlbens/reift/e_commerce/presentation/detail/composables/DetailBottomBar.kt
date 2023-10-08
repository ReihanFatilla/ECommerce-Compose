package com.trawlbens.reift.e_commerce.presentation.detail.composables

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trawlbens.reift.core.domain.model.Product

@Composable
fun DetailBottomBar(product: Product) {
    Row(
        modifier = Modifier.padding(bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column{
            Text(text = "Price", color = Color.Gray, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            Text(text = "$ "+product.price.toString(), color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 23.sp)
        }
        Button(modifier = Modifier.fillMaxWidth(),onClick = {  }, colors = ButtonDefaults.buttonColors(containerColor = Color.Black), shape = RoundedCornerShape(10.dp)) {
            Text(text = "Add To Cart", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
    }
}