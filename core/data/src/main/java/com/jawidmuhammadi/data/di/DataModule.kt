package com.jawidmuhammadi.data.di

import com.jawidmuhammadi.data.ProductRepository
import com.jawidmuhammadi.data.ProductRepositoryImp
import com.jawidmuhammadi.network.ProductNetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideProductRepository(
        networkDataSource: ProductNetworkDataSource,
        dispatcher: Dispatchers
    ): ProductRepository {
        return ProductRepositoryImp(networkDataSource, dispatcher)
    }
}