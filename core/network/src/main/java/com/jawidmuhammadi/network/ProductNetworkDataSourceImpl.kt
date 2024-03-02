package com.jawidmuhammadi.network

internal class ProductNetworkDataSourceImpl(
    private val restClient: ProductRestClient
) : ProductNetworkDataSource {
    override suspend fun getProducts(): ProductsDto {
        return restClient.getProducts()
    }
}