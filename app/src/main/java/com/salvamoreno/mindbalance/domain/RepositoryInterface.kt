package com.salvamoreno.mindbalance.domain

import com.salvamoreno.mindbalance.data.remote.request.ChangeForgottenPassRequest
import com.salvamoreno.mindbalance.data.remote.request.ChangePasswordRequest
import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest
import com.salvamoreno.mindbalance.data.remote.response.TokenRemote

interface RepositoryInterface {
    suspend fun signIn(email: String, password: String): TokenRemote
    suspend fun changePassword(changePasswordRequest: ChangePasswordRequest)
    suspend fun confirmIdentity(identityRequest: IdentityRequest)
    suspend fun changeForgottenPassword(newPassword: String): Boolean
}