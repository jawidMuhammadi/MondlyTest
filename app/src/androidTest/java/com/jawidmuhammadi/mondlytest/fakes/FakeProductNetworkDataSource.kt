package com.jawidmuhammadi.mondlytest.fakes

import com.jawidmuhammadi.common.dto.ProductsDto
import com.jawidmuhammadi.network.ProductNetworkDataSource
import com.jawidmuhammadi.sharedtest.data.ProductsDtoMother

class FakeProductNetworkDataSource : ProductNetworkDataSource {
    override suspend fun getProducts(): ProductsDto {
        return ProductsDtoMother.buildProductsDto(10)
    }
}