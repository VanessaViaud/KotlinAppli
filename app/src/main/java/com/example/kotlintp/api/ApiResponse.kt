package com.example.kotlintp.api

data class ApiResponse<T>(var code: String, var message : String, var data : T?) {
}