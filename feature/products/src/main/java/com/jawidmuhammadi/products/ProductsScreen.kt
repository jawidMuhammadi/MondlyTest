package com.jawidmuhammadi.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
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
fun ProductsScreen(
    viewModel: ProductListViewModel = viewModel(),
    windowSizeClass: WindowSizeClass
) {
    val uiState: ProductsUiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is ProductsUiState.Success -> {
            ProductsContent(
                products = (uiState as ProductsUiState.Success).products,
                windowSizeClass = windowSizeClass.widthSizeClass
            )
        }

        is ProductsUiState.Error -> {}
        else -> {}
    }

}

@Composable
private fun ProductsContent(
    products: List<ProductItem>,
    windowSizeClass: WindowWidthSizeClass
) {
    val columnCount = when (windowSizeClass) {
        WindowWidthSizeClass.Compact -> 2
        WindowWidthSizeClass.Medium -> 3
        WindowWidthSizeClass.Expanded -> 4
        else -> 2
    }
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        columns = GridCells.Fixed(columnCount)
    ) {
        items(products) { product ->
            ProductCard(product)
        }
    }
}