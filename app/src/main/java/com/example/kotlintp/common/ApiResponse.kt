package com.example.kotlintp.common


data class ApiResponse<T>(var code: String, var message : String, var data : T?) {
}