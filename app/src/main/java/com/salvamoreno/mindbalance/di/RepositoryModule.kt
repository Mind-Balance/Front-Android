package com.salvamoreno.mindbalance.di

import com.salvamoreno.mindbalance.data.Repository
import com.salvamoreno.mindbalance.domain.RepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsRepositoryInterface(repository: Repository): RepositoryInterface
}