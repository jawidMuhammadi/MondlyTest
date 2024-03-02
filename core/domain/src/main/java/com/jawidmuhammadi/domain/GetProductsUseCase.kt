package com.jawidmuhammadi.domain

import com.jawidmuhammadi.data.ProductRepository
import com.jawidmuhammadi.model.ProductItem
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend fun invoke(): List<ProductItem> {
        return productRepository.getProducts()
    }
}