package com.salvamoreno.mindbalance.data.local

interface LocalDataSourceInterface {
    fun saveAccessToken(accessToken: String)
    fun getAccessToken(): String
    fun saveRefreshToken(refreshToken: String)
    fun getRefreshToken(): String
    fun saveEmail(email: String)
    fun getEmail(): String
    fun saveDNI(dni: String)
    fun getDNI(): String
    fun savePassword(password: String)
    fun getPassword(): String
}
