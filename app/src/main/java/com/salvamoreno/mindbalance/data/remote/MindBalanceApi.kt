package com.salvamoreno.mindbalance.data.remote

import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest
import com.salvamoreno.mindbalance.data.remote.response.TokenRemote
import retrofit2.http.Body
import retrofit2.http.POST

interface MindBalanceApi {
    @POST("auth/identity")
    suspend fun confirmIdentity(@Body identityRequest: IdentityRequest): TokenRemote
}