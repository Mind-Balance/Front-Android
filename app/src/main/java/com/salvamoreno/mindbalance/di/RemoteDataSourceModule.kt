package com.salvamoreno.mindbalance.di

import com.salvamoreno.mindbalance.data.remote.RemoteDataSource
import com.salvamoreno.mindbalance.data.remote.RemoteDataSourceInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindsRemoteDataSourceInterface(remoteDataSource: RemoteDataSource): RemoteDataSourceInterface
}