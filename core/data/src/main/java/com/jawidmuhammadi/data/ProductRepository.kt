package com.jawidmuhammadi.data

import com.jawidmuhammadi.model.ProductItem
import com.jawidmuhammadi.network.ProductNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ProductRepository {
    suspend fun getProducts(): List<ProductItem>
}

internal class ProductRepositoryImp(
    private val networkDataSource: ProductNetworkDataSource,
    private val productDtoMapper: ProductDtoMapper,
    private val dispatcher: Dispatchers
) : ProductRepository {
    override suspend fun getProducts(): List<ProductItem> {
        return withContext(dispatcher.IO) {
            productDtoMapper.map(networkDataSource.getProducts())
        }
    }
}

