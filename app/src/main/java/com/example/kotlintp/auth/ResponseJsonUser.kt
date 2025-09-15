package com.example.kotlintp.auth

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class ResponseJsonUser (var code: Int, var message: String, var data: Token) {
}

@JsonClass(generateAdapter = true)
class Token (var token: String)