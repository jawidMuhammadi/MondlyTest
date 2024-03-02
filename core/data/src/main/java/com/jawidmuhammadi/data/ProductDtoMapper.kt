package com.jawidmuhammadi.data

import com.jawidmuhammadi.model.ProductItem
import com.jawidmuhammadi.network.ProductsDto
import javax.inject.Inject

class ProductDtoMapper @Inject constructor() {
    fun map(productsDto: ProductsDto): List<ProductItem> {
        val productList = mutableListOf<ProductItem>()
        productsDto.dataCollection.map {
            productList.add(
                ProductItem(
                    id = it.item.id,
                    name = it.item.attributes.name,
                    description = it.item.attributes.description,
                    imageUrl = it.item.attributes.imageInfo.imageUrl
                )
            )
        }
        return productList
    }
}