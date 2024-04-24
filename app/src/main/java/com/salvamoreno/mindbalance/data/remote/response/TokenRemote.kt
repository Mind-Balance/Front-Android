package com.salvamoreno.mindbalance.data.remote.response

import com.squareup.moshi.Json

data class TokenRemote(
    @Json(name = "accessToken") val accessToken: String,
    @Json(name = "refreshToken") val refreshToken: String
)