package com.jawidmuhammadi.network

import com.jawidmuhammadi.sharedtest.ProductsDtoMother.buildProductsDto
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProductNetworkDataSourceTest {

    private val productRestClient: ProductRestClient = mockk()

    @Before
    fun setUp() = runTest {
        coEvery { productRestClient.getProducts() } returns buildProductsDto(2)
    }

    @Test
    fun `given ProductRestClient, call getProducts, then correct items returned`() = runTest {
        val productNetworkDataSource = ProductNetworkDataSourceImpl(productRestClient)

        val result = productNetworkDataSource.getProducts()
        val expected = buildProductsDto(2)

        assertEquals(result, expected)
    }
}