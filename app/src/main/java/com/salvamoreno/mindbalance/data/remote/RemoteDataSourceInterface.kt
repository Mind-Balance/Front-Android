package com.salvamoreno.mindbalance.data.remote

import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest
import com.salvamoreno.mindbalance.data.remote.response.TokenRemote

interface RemoteDataSourceInterface {
    suspend fun confirmIdentity(identityRequest: IdentityRequest): TokenRemote
}