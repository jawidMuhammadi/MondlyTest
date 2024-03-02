package com.jawidmuhammadi.network

interface ProductNetworkDataSource {

    suspend fun getProducts(): ProductsDto
}