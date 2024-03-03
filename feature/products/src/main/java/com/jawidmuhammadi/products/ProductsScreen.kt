package com.jawidmuhammadi.products

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
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
                windowSizeClass = windowSizeClass.widthSizeClass,
                onProductItemClick = { productItem ->
                    //   TODO("Handle click events")
                }
            )
        }

        is ProductsUiState.Error -> {}
        is ProductsUiState.Loading -> {
            LoadingContent()
        }

        else -> {}
    }
}

@Composable
private fun ProductsContent(
    products: List<ProductItem>,
    windowSizeClass: WindowWidthSizeClass,
    onProductItemClick: (productItem: ProductItem) -> Unit
) {
    val gridState = rememberLazyGridState()
    val topPadding by remember {
        derivedStateOf { if (gridState.firstVisibleItemIndex > 0) 0.dp else 16.dp }
    }
    val animatedPadding by animateDpAsState(targetValue = topPadding, label = "")
    val columnCount = calculateColumnCount(windowSizeClass)
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = animatedPadding, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        columns = GridCells.Fixed(columnCount),
        state = gridState
    ) {
        items(products) { product ->
            ProductCard(product, onProductItemClick)
        }
    }
}

@Composable
private fun calculateColumnCount(windowSizeClass: WindowWidthSizeClass): Int {
    return when (windowSizeClass) {
        WindowWidthSizeClass.Compact -> 2
        WindowWidthSizeClass.Medium -> 3
        WindowWidthSizeClass.Expanded -> 4
        else -> 1
    }
}

@Composable
fun LoadingContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .size(80.dp),
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Preview
@Composable
private fun ProductContentPreview() {
    val productList = listOf(
        ProductItem(id = "1", name = "name", description = "description", imageUrl = ""),
        ProductItem(id = "2", name = "name2", description = "description", imageUrl = ""),
        ProductItem(id = "3", name = "name3", description = "description", imageUrl = "")
    )
    ProductsContent(
        products = productList,
        windowSizeClass = WindowWidthSizeClass.Medium,
        {}
    )
}