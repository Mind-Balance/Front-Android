package com.salvamoreno.mindbalance.ui.passForgotten

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salvamoreno.mindbalance.data.remote.request.IdentityRequest
import com.salvamoreno.mindbalance.domain.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PassForgottenViewModel @Inject constructor(
    private val repository: RepositoryInterface,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {
    // FUNCTIONS
    fun onConfirmIdentity(email: String, dni: String) {
        viewModelScope.launch {
            withContext(dispatcher) {
                val identityRequest: IdentityRequest = IdentityRequest(email, dni)
                repository.confirmIdentity(identityRequest)
            }
        }
    }
}