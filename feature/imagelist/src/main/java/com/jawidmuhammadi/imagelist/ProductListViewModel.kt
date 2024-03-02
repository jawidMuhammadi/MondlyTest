package com.jawidmuhammadi.imagelist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jawidmuhammadi.domain.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProducts: GetProductsUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            try {
                val result = getProducts()
                Log.d("products: ", result.toString())
            } catch (exp: Exception) {
                exp.printStackTrace()
            }
        }
    }
}