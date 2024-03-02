package com.jawidmuhammadi.network


import com.google.gson.annotations.SerializedName

data class ProductsDto(
    @SerializedName("dataCollection")
    val dataCollection: List<DataCollection>
) {
    data class DataCollection(
        @SerializedName("item")
        val item: Item
    ) {
        data class Item(
            @SerializedName("attributes")
            val attributes: Attributes,
            @SerializedName("id")
            val id: String
        ) {
            data class Attributes(
                @SerializedName("description")
                val description: String,
                @SerializedName("imageInfo")
                val imageInfo: ImageInfo,
                @SerializedName("name")
                val name: String
            ) {
                data class ImageInfo(
                    @SerializedName("imageUrl")
                    val imageUrl: String
                )
            }
        }
    }
}