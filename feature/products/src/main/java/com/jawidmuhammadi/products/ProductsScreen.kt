package com.jawidmuhammadi.products

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.jawidmuhammadi.imagelist.ProductListViewModel
import com.jawidmuhammadi.imagelist.ProductsUiState
import com.jawidmuhammadi.model.ProductItem

@Composable
fun ProductsScreen(viewModel: ProductListViewModel = viewModel()) {

    val uiState: ProductsUiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is ProductsUiState.Success -> {
            ProductList(products = (uiState as ProductsUiState.Success).products)
        }

        is ProductsUiState.Error -> {}
        else -> {}
    }

}

@Composable
private fun ProductList(products: List<ProductItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(products) { product ->
            ProductCard(product)
        }
    }
}

@Composable
fun ProductCard(product: ProductItem) {
    OutlinedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .width(250.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
                painter = rememberAsyncImagePainter(model = product.imageUrl),
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
