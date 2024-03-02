package com.jawidmuhammadi.data

import com.jawidmuhammadi.network.ProductNetworkDataSource
import com.jawidmuhammadi.network.ProductsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ProductRepository {
    suspend fun getProducts(): ProductsDto
}

internal class ProductRepositoryImp(
    private val networkDataSource: ProductNetworkDataSource,
    private val dispatcher: Dispatchers
) : ProductRepository {
    override suspend fun getProducts(): ProductsDto {
        return withContext(dispatcher.IO) {
            networkDataSource.getProducts()
        }

    }
}

