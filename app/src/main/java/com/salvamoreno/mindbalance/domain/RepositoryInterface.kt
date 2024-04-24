package com.salvamoreno.mindbalance.domain

import com.salvamoreno.mindbalance.data.remote.request.ChangeForgottenPassRequest
import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest

interface RepositoryInterface {
    suspend fun confirmIdentity(identityRequest: IdentityRequest)
    suspend fun changeForgottenPassword(newPassword: String): Boolean
}