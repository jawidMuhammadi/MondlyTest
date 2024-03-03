package com.jawidmuhammadi.domain

import com.jawidmuhammadi.data.ProductRepository
import com.jawidmuhammadi.sharedtest.data.ProductItemMother
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetProductsUseCaseTest {

    private val productRepository: ProductRepository = mockk {
        coEvery { getProducts() } returns ProductItemMother.buildProductItems(3)
    }

    @Test
    fun `given productRepository, when getProductsUseCase called, then return a list of products`() = runTest{
        val getProducts = GetProductsUseCase(productRepository)

        val actualResult = getProducts.invoke()
        val expected = ProductItemMother.buildProductItems(3)

        assertEquals(actualResult, expected)
    }
}