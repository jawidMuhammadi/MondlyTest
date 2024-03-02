package com.jawidmuhammadi.imagelist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jawidmuhammadi.domain.GetProductsUseCase
import com.jawidmuhammadi.model.ProductItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProducts: GetProductsUseCase
) : ViewModel() {

    private var _uiStat = MutableStateFlow<ProductsUiState>(ProductsUiState.Loading)
    val uiState: StateFlow<ProductsUiState> = _uiStat

    init {
        viewModelScope.launch {
            try {
                val result = getProducts()
                _uiStat.value = ProductsUiState.Success(result)
                Log.d("products: ", result.toString())
            } catch (exp: Exception) {
                _uiStat.value = ProductsUiState.Error("Opps, something went wrong!")
            }
        }
    }
}

sealed interface ProductsUiState {
    data object Loading : ProductsUiState
    data class Success(val products: List<ProductItem>) : ProductsUiState
    data class Error(val message: String) : ProductsUiState
}