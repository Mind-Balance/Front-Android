package com.salvamoreno.mindbalance.data

import com.salvamoreno.mindbalance.data.local.LocalDataSourceInterface
import com.salvamoreno.mindbalance.data.local.sharedPreferences.SharedPreferencesService
import com.salvamoreno.mindbalance.data.remote.RemoteDataSourceInterface
import com.salvamoreno.mindbalance.data.remote.request.ChangeForgottenPassRequest
import com.salvamoreno.mindbalance.data.remote.request.ChangePasswordRequest
import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest
import com.salvamoreno.mindbalance.data.remote.response.TokenRemote
import com.salvamoreno.mindbalance.domain.RepositoryInterface
import javax.inject.Inject

class Repository @Inject constructor(
    private val localDataSource: LocalDataSourceInterface,
    private val remoteDataSource: RemoteDataSourceInterface,
) : RepositoryInterface {
    override suspend fun signIn(email: String, password: String): TokenRemote {
        // Save information
        localDataSource.saveEmail(email)
        localDataSource.savePassword(password)

        // Api call
        val remoteToken: TokenRemote = remoteDataSource.signIn()

        return if (remoteToken.accessToken.isNotEmpty()) {
            // Save tokens
            localDataSource.saveAccessToken(remoteToken.accessToken)
            localDataSource.saveRefreshToken(remoteToken.refreshToken)

            remoteToken
        } else {
            remoteToken
        }
    }

    override suspend fun changePassword(changePasswordRequest: ChangePasswordRequest) {
        // Api call
        val remoteToken: TokenRemote = remoteDataSource.changePassword(changePasswordRequest)

        // Save tokens
        localDataSource.saveAccessToken(remoteToken.accessToken)
        localDataSource.saveRefreshToken(remoteToken.refreshToken)
    }

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