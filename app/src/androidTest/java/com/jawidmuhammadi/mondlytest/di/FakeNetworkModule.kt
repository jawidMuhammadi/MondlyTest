package com.jawidmuhammadi.mondlytest.di

import com.jawidmuhammadi.mondlytest.fakes.FakeProductNetworkDataSource
import com.jawidmuhammadi.network.ProductNetworkDataSource
import com.jawidmuhammadi.network.di.NetworkModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class]
)
class FakeNetworkModule {
    @Singleton
    @Provides
    fun provideProductNetworkDataSource(): ProductNetworkDataSource = FakeProductNetworkDataSource()
}