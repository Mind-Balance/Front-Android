package com.salvamoreno.mindbalance.domain.models

data class Token(
    val accessToken: String,
    val refreshToken: String
)