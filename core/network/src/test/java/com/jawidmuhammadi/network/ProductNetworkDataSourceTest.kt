package com.jawidmuhammadi.network

import com.jawidmuhammadi.sharedtest.data.ProductsDtoMother.buildProductsDto
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProductNetworkDataSourceTest {

    private val productRestClient: ProductRestClient = mockk()
    private lateinit var productNetworkDataSource: ProductNetworkDataSource

    @Before
    fun setUp() = runTest {
        coEvery { productRestClient.getProducts() } returns buildProductsDto(2)
    }

    @Test
    fun `given ProductRestClient, call getProducts, then correct items returned`() = runTest {
        productNetworkDataSource = ProductNetworkDataSourceImpl(productRestClient)

        val result = productNetworkDataSource.getProducts()
        val expected = buildProductsDto(2)

        assertEquals(expected, result)
    }
}