package com.jawidmuhammadi.network.di

import com.jawidmuhammadi.network.ProductNetworkDataSource
import com.jawidmuhammadi.network.ProductNetworkDataSourceImpl
import com.jawidmuhammadi.network.ProductRestClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class NetworkModule {

    @Singleton
    @Provides
    fun provideProductNetworkDataSource(restClient: ProductRestClient): ProductNetworkDataSource =
        ProductNetworkDataSourceImpl(restClient)

    @Singleton
    @Provides
    fun provideProductRestClient(retrofit: Retrofit): ProductRestClient =
        retrofit.create(ProductRestClient::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://europe-west1-mondly-workflows.cloudfunctions.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}