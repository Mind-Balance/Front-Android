package com.salvamoreno.mindbalance.ui.changePassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salvamoreno.mindbalance.data.remote.request.ChangePasswordRequest
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
class ChangePasswordViewModel @Inject constructor(
    private val repository: RepositoryInterface,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {
    // PROPERTIES
    private val _newPasswordChanged: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val newPasswordChanged: StateFlow<Boolean> = _newPasswordChanged.asStateFlow()

    // FUNCTIONS
    fun onChangePassword(
        newPassword: String
    ) {
        viewModelScope.launch {
            withContext(dispatcher) {
                val changePasswordRequest = ChangePasswordRequest(newPassword)
                repository.changePassword(changePasswordRequest)
            }
            withContext(dispatcher) {
                _newPasswordChanged.value = true
            }
        }
    }
}