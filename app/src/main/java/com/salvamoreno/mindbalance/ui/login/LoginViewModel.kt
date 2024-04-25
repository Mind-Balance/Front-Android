package com.salvamoreno.mindbalance.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salvamoreno.mindbalance.domain.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: RepositoryInterface,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {
    // PROPERTIES
    private val _accessToken: MutableStateFlow<String> = MutableStateFlow("nada")
    val accessToken: StateFlow<String> = _accessToken.asStateFlow()

    private val _refreshToken: MutableStateFlow<String> = MutableStateFlow("nada")
    val refreshToken: StateFlow<String> = _refreshToken.asStateFlow()

    // FUNCTIONS
    fun onSignIn(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            withContext(dispatcher) {
                val remoteToken = repository.signIn(email, password)

                if (remoteToken.accessToken.isNotEmpty()) {
                    _accessToken.value = remoteToken.accessToken
                    _refreshToken.value = remoteToken.refreshToken
                } else {
                    _accessToken.value = "vacio"
                    _refreshToken.value = "vacio"
                }
            }
        }
    }
}