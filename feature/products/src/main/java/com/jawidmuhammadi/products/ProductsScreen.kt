package com.jawidmuhammadi.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
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
fun ProductList(products: List<ProductItem>) {
    products.forEachIndexed { _, productItem ->
        Column {
            Text(modifier = Modifier.padding(16.dp), text = productItem.name)
        }
    }
}