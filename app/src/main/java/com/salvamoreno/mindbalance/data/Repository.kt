package com.salvamoreno.mindbalance.data

import com.salvamoreno.mindbalance.data.local.LocalDataSourceInterface
import com.salvamoreno.mindbalance.data.local.sharedPreferences.SharedPreferencesService
import com.salvamoreno.mindbalance.data.remote.RemoteDataSourceInterface
import com.salvamoreno.mindbalance.data.remote.request.ChangeForgottenPassRequest
import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest
import com.salvamoreno.mindbalance.data.remote.response.TokenRemote
import com.salvamoreno.mindbalance.domain.RepositoryInterface
import javax.inject.Inject

class Repository @Inject constructor(
    private val localDataSource: LocalDataSourceInterface,
    private val remoteDataSource: RemoteDataSourceInterface,
) : RepositoryInterface {
    override suspend fun confirmIdentity(identityRequest: IdentityRequest) {
        // Api call
        val remoteToken: TokenRemote = remoteDataSource.confirmIdentity(identityRequest)

        // Save tokens
        localDataSource.saveAccessToken(remoteToken.accessToken)
        localDataSource.saveRefreshToken(remoteToken.refreshToken)

        // Save information
        localDataSource.saveEmail(identityRequest.email)
        localDataSource.saveDNI(identityRequest.dni)
    }

    override suspend fun changeForgottenPassword(newPassword: String): Boolean {
        // Request
        val email = localDataSource.getEmail()
        val dni = localDataSource.getDNI()
        val changeForgottenPassRequest = ChangeForgottenPassRequest(email, dni, newPassword)
        // Api call
        return remoteDataSource.changeForgottenPassword(changeForgottenPassRequest)
    }
}