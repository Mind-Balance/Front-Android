package com.salvamoreno.mindbalance.data.remote.request

data class ChangeForgottenPassRequest(
    val email: String,
    val dni: String,
    val newPassword: String
)