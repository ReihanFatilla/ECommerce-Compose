package com.trawlbens.reift.e_commerce.presentation.search.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(query: String, onValueChange: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF1F1F1)),
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        placeholder = { Text(text = "Search") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        )
    )
}