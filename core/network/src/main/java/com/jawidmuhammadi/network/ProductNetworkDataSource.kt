package com.jawidmuhammadi.network

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