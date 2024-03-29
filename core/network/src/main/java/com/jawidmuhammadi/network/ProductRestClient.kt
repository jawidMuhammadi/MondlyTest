package com.jawidmuhammadi.network

import com.jawidmuhammadi.common.dto.ProductsDto
import retrofit2.http.GET

internal interface ProductRestClient {
    @GET("/mondly_android_code_task_json")
    suspend fun getProducts(): ProductsDto
}