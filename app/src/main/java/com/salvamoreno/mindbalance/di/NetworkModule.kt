package com.salvamoreno.mindbalance.di

import android.content.Context
import android.util.Log
import com.salvamoreno.mindbalance.data.local.sharedPreferences.SharedPreferencesService
import com.salvamoreno.mindbalance.data.remote.MindBalanceApi
import com.salvamoreno.mindbalance.di.annotations.NetworkQualifier
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val API_KEY: String = "55618b9b-4447-4cde-bf22-42f62f01e6cd"
const val API_URL: String = "http://10.0.2.2:8080/"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    @NetworkQualifier
    fun provideSharedPreferencesManager(context: Context): SharedPreferencesService = SharedPreferencesService(context)

    @Provides
    fun providesOkHttpClient(sharedPreferencesService: SharedPreferencesService): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val originalRequest = chain.request()
            if (originalRequest.url.encodedPath.contains("signin")) {
                val email = sharedPreferencesService.getEmail()
                val password = sharedPreferencesService.getPassword()
                val credentials = Credentials.basic(email, password)
                val firstHeaderRequest =
                    originalRequest.newBuilder().addHeader("MindBalance-ApiKey", API_KEY).build()
                val secondHeaderRequest = firstHeaderRequest.newBuilder().addHeader("Authorization", credentials).build()
                chain.proceed(secondHeaderRequest)
            } else if (originalRequest.url.encodedPath.contains("change")) {
                val email = sharedPreferencesService.getEmail()
                val password = sharedPreferencesService.getPassword()
                val credentials = Credentials.basic(email, password)
                val firstHeaderRequest =
                    originalRequest.newBuilder().addHeader("MindBalance-ApiKey", API_KEY).build()
                val secondHeaderRequest = firstHeaderRequest.newBuilder().addHeader("Authorization", credentials).build()
                chain.proceed(secondHeaderRequest)
            } else if (originalRequest.url.encodedPath.contains("identity")) {
                val newRequest =
                    originalRequest.newBuilder().addHeader("MindBalance-ApiKey", API_KEY).build()
                chain.proceed(newRequest)
            } else if (originalRequest.url.encodedPath.contains("forgotten")) {
                val firstHeaderRequest =
                    originalRequest.newBuilder().addHeader("MindBalance-ApiKey", API_KEY).build()
                val accessToken = sharedPreferencesService.getAccessToken()
                val secondHeaderRequest = firstHeaderRequest.newBuilder().addHeader("Authorization", "Bearer $accessToken").build()
                chain.proceed(secondHeaderRequest)
            } else {
                chain.proceed(originalRequest)
            }
        }.build()
    }

    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder().client(okHttpClient).baseUrl(API_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun providesMindBalanceApi(retrofit: Retrofit): MindBalanceApi =
        retrofit.create(MindBalanceApi::class.java)
}