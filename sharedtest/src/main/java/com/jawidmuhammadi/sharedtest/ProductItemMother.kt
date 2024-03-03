package com.jawidmuhammadi.sharedtest

import com.jawidmuhammadi.model.ProductItem

object ProductItemMother {
    fun buildProductItems(itemCount: Int): List<ProductItem> {
        val products = mutableListOf<ProductItem>()
        for (i in 1..itemCount) {
            products.add(
                ProductItem(
                    id = "id$i",
                    name = "name$i",
                    description = "description$i",
                    imageUrl = "imageUrl$i"
                )
            )
        }
        return products
    }
}