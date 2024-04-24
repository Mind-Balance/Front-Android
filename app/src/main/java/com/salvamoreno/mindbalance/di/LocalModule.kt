package com.salvamoreno.mindbalance.di

import android.content.Context
import com.salvamoreno.mindbalance.data.local.LocalDataSource
import com.salvamoreno.mindbalance.data.local.LocalDataSourceInterface
import com.salvamoreno.mindbalance.data.local.sharedPreferences.SharedPreferencesService
import com.salvamoreno.mindbalance.di.annotations.LocalQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    @LocalQualifier
    fun provideSharedPreferencesManager(context: Context): SharedPreferencesService = SharedPreferencesService(context)

    @Provides
    fun providesLocalDataSourceInterface(localDataSource: LocalDataSource): LocalDataSourceInterface {
        return localDataSource
    }
}