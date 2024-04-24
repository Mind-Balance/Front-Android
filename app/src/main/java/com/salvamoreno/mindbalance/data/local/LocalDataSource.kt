package com.salvamoreno.mindbalance.data.local

import com.salvamoreno.mindbalance.data.local.sharedPreferences.SharedPreferencesService
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val sharedPreferencesService: SharedPreferencesService
): LocalDataSourceInterface {
    override fun saveAccessToken(accessToken: String) = sharedPreferencesService.saveAccessToken(token = accessToken)

    override fun getAccessToken(): String = sharedPreferencesService.getAccessToken()

    override fun saveRefreshToken(refreshToken: String) = sharedPreferencesService.saveRefreshToken(token = refreshToken)

    override fun getRefreshToken(): String = sharedPreferencesService.getRefreshToken()

    override fun saveEmail(email: String) = sharedPreferencesService.saveEmail(email = email)

    override fun getEmail(): String = sharedPreferencesService.getEmail()

    override fun saveDNI(dni: String) = sharedPreferencesService.saveDNI(dni = dni)

    override fun getDNI(): String = sharedPreferencesService.getDNI()
}