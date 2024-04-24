package com.salvamoreno.mindbalance.data.remote

import com.salvamoreno.mindbalance.data.remote.request.ChangeForgottenPassRequest
import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest
import com.salvamoreno.mindbalance.data.remote.response.TokenRemote
import retrofit2.http.Body
import retrofit2.http.POST

interface MindBalanceApi {
    @POST("api/v1/auth/identity")
    suspend fun confirmIdentity(@Body identityRequest: IdentityRequest): TokenRemote

    @POST("api/v1/password/forgotten")
    suspend fun changeForgottenPassword(@Body changeForgottenPassRequest: ChangeForgottenPassRequest): Boolean
}