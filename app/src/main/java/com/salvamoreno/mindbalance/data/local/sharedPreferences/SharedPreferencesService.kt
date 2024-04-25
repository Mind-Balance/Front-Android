package com.salvamoreno.mindbalance.data.local.sharedPreferences

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesService @Inject constructor(@ApplicationContext private val context: Context) {
    // PROPERTIES
    private val PREFS_NAME = "MindBalance"
    private val ACCESS_TOKEN_KEY = "accessTokenKey"
    private val REFRESH_TOKEN_KEY = "refreshTokenKey"
    private val EMAIL_KEY = "emailKey"
    private val DNI_KEY = "dniKey"
    private val PASSWORD_KEY = "passwordKey"

    private val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    // FUNCTIONS
    fun getAccessToken(key: String = ACCESS_TOKEN_KEY, defaultValue: String = "No Access Token"): String {
        return sharedPref.getString(key, defaultValue) ?: defaultValue
    }

    fun saveAccessToken(key: String = ACCESS_TOKEN_KEY, token: String) {
        with(sharedPref.edit()) {
            putString(key, token)
            commit()
        }
    }

    fun getRefreshToken(key: String = REFRESH_TOKEN_KEY, defaultValue: String = "No Refresh Token"): String {
        return sharedPref.getString(key, defaultValue) ?: defaultValue
    }

    fun saveRefreshToken(key: String = REFRESH_TOKEN_KEY, token: String) {
        with(sharedPref.edit()) {
            putString(key, token)
            commit()
        }
    }

    fun getEmail(key: String = EMAIL_KEY, defaultValue: String = "No Email"): String {
        return sharedPref.getString(key, defaultValue) ?: defaultValue
    }

    fun saveEmail(key: String = EMAIL_KEY, email: String) {
        with(sharedPref.edit()) {
            putString(key, email)
            commit()
        }
    }

    fun getDNI(key: String = DNI_KEY, defaultValue: String = "No DNI"): String {
        return sharedPref.getString(key, defaultValue) ?: defaultValue
    }

    fun saveDNI(key: String = DNI_KEY, dni: String) {
        with(sharedPref.edit()) {
            putString(key, dni)
            commit()
        }
    }

    fun getPassword(key: String = PASSWORD_KEY, defaultValue: String = "No Password"): String {
        return sharedPref.getString(key, defaultValue) ?: defaultValue
    }

    fun savePassword(key: String = PASSWORD_KEY, password: String) {
        with(sharedPref.edit()) {
            putString(key, password)
            commit()
        }
    }
}