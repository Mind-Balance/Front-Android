package com.salvamoreno.mindbalance.domain

import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest

interface RepositoryInterface {
    suspend fun confirmIdentity(identityRequest: IdentityRequest)
}