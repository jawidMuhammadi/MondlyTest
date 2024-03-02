package com.jawidmuhammadi.network

import retrofit2.http.GET

interface ProductRestClient {
    @GET("/mondly_android_code_task_json")
    suspend fun getProducts(): ProductsDto
}