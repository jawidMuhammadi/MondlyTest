package com.jawidmuhammadi.sharedtest.data

import com.jawidmuhammadi.common.dto.ProductsDto
import com.jawidmuhammadi.common.dto.ProductsDto.DataCollection
import com.jawidmuhammadi.common.dto.ProductsDto.DataCollection.Item.Attributes

object ProductsDtoMother {
    fun buildProductsDto(itemCount: Int): ProductsDto {
        val dataCollection = mutableListOf<DataCollection>()
        for (i in 1..itemCount) {
            dataCollection.add(
                DataCollection(
                    item = DataCollection.Item(
                        id = "id$i",
                        attributes = Attributes(
                            description = "description$i",
                            name = "name$i",
                            imageInfo = Attributes.ImageInfo(
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