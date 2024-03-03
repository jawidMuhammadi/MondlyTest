package com.jawidmuhammadi.products

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.jawidmuhammadi.imagelist.R
import com.jawidmuhammadi.model.ProductItem

@Composable
fun ProductCard(product: ProductItem) {
    OutlinedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
                painter = rememberAsyncImagePainter(
                    model = product.imageUrl,
                    fallback = painterResource(
                        id = R.drawable.mondly
                    )
                ),
                contentDescription = null
            )
            Text(
                text = product.name,
                modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = product.description,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}