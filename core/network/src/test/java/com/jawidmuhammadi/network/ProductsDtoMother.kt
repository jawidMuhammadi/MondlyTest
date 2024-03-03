package com.jawidmuhammadi.network

import com.jawidmuhammadi.network.ProductsDto.DataCollection
import com.jawidmuhammadi.network.ProductsDto.DataCollection.Item
import com.jawidmuhammadi.network.ProductsDto.DataCollection.Item.Attributes
import com.jawidmuhammadi.network.ProductsDto.DataCollection.Item.Attributes.ImageInfo

object ProductsDtoMother {
    fun buildProductsDto(itemCount: Int): ProductsDto {
        val dataCollection = mutableListOf<DataCollection>()
        for (i in 1..itemCount) {
            dataCollection.add(
                DataCollection(
                    item = Item(
                        id = "id$i",
                        attributes = Attributes(
                            description = "description$i",
                            name = "name$i",
                            imageInfo = ImageInfo(
                                imageUrl = "imageUrl$i"
                            )
                        )
                    )
                )
            )
        }
        return ProductsDto(
            dataCollection = dataCollection
        )
    }
}