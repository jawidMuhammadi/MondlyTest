package com.jawidmuhammadi.data

import com.jawidmuhammadi.network.ProductNetworkDataSource
import com.jawidmuhammadi.sharedtest.ProductItemMother
import com.jawidmuhammadi.sharedtest.ProductsDtoMother
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProductRepositoryTest {

    private lateinit var productRepository: ProductRepository
    private val networkDataSource: ProductNetworkDataSource = mockk {
        coEvery { getProducts() } returns ProductsDtoMother.buildProductsDto(2)
    }
    private val productDtoMapper = ProductDtoMapper()

    @Test
    fun `given productRepository, when getProducts called, return correctly mapped product items`() =
        runTest {
            productRepository = ProductRepositoryImp(
                networkDataSource,
                productDtoMapper,
                UnconfinedTestDispatcher()
            )

            val actualResult = productRepository.getProducts()
            val expected = ProductItemMother.buildProductItems(2)

            assertEquals(actualResult, expected)
        }
}
