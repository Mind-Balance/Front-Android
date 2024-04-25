package com.salvamoreno.mindbalance.data.remote

import com.salvamoreno.mindbalance.data.remote.request.ChangeForgottenPassRequest
import com.salvamoreno.mindbalance.data.remote.request.ChangePasswordRequest
import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest
import com.salvamoreno.mindbalance.data.remote.response.TokenRemote
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val mindBalanceApi: MindBalanceApi) :
    RemoteDataSourceInterface {
    override suspend fun signIn(): TokenRemote =
        mindBalanceApi.signIn()

    override suspend fun changePassword(changePasswordRequest: ChangePasswordRequest): TokenRemote =
        mindBalanceApi.changePassword(changePasswordRequest)

    override suspend fun confirmIdentity(identityRequest: IdentityRequest): TokenRemote =
        mindBalanceApi.confirmIdentity(identityRequest)

    override suspend fun changeForgottenPassword(changeForgottenPassRequest: ChangeForgottenPassRequest): Boolean =
        mindBalanceApi.changeForgottenPassword(changeForgottenPassRequest)
}