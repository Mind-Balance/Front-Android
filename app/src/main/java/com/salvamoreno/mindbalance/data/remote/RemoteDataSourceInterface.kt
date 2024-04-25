package com.salvamoreno.mindbalance.data.remote

import com.salvamoreno.mindbalance.data.remote.request.ChangeForgottenPassRequest
import com.salvamoreno.mindbalance.data.remote.request.ChangePasswordRequest
import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest
import com.salvamoreno.mindbalance.data.remote.response.TokenRemote
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RemoteDataSourceInterface {
    suspend fun signIn(): TokenRemote
    suspend fun changePassword(changePasswordRequest: ChangePasswordRequest): TokenRemote
    suspend fun confirmIdentity(identityRequest: IdentityRequest): TokenRemote
    suspend fun changeForgottenPassword(changeForgottenPassRequest: ChangeForgottenPassRequest): Boolean
}
