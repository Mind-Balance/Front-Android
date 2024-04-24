package com.salvamoreno.mindbalance.ui.changeForgottenPass

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
class ChangeForgottenPassViewModel @Inject constructor(
    private val repository: RepositoryInterface,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {
    // PROPERTIES
    private val _newPasswordChanged: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val newPasswordChanged: StateFlow<Boolean> = _newPasswordChanged.asStateFlow()

    // FUNCTIONS
    fun onChangeForgottenPassword(
        newPassword: String
    ) {
        viewModelScope.launch {
            withContext(dispatcher) {
                _newPasswordChanged.value = repository.changeForgottenPassword(newPassword)
            }
        }
    }
}