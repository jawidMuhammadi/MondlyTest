package com.jawidmuhammadi.products

import com.jawidmuhammadi.domain.GetProductsUseCase
import com.jawidmuhammadi.sharedtest.coroutines.MainDispatcherRule
import com.jawidmuhammadi.sharedtest.data.ProductItemMother
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class ProductListViewModelTest {

    @get:Rule
    val coroutineRule = MainDispatcherRule()

    private lateinit var viewModel: ProductListViewModel
    private val getProductsUseCase: GetProductsUseCase = mockk()

    @Test
    fun `given getProductUseCase returns success, when viewmodel initialized, then update viewState with products`() =
        runTest {
            coEvery { getProductsUseCase.invoke() } returns ProductItemMother.buildProductItems(2)
            viewModel = ProductListViewModel(getProductsUseCase)

            val actualState = viewModel.uiState.value
            val expected = ProductsUiState.Success(ProductItemMother.buildProductItems(2))

            coVerify { getProductsUseCase.invoke() }
            assertEquals(expected, actualState)
        }

    @Test
    fun `given getProductUseCase fails, when viewmodel initialized, then update viewState with error`() =
        runTest {
            coEvery { getProductsUseCase.invoke() } throws Exception("Ops, something went wrong!")
            viewModel = ProductListViewModel(getProductsUseCase)

            val actualState = viewModel.uiState.value
            val expected = ProductsUiState.Error("Ops, something went wrong!")

            coVerify { getProductsUseCase.invoke() }
            assertEquals(expected, actualState)
        }

}