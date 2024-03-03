package com.jawidmuhammadi.network

import com.jawidmuhammadi.common.dto.ProductsDto

interface ProductNetworkDataSource {
    suspend fun getProducts(): ProductsDto
}

internal class ProductNetworkDataSourceImpl(
    private val restClient: ProductRestClient
) : ProductNetworkDataSource {
    override suspend fun getProducts(): ProductsDto {
        return restClient.getProducts()
    }
}