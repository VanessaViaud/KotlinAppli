package com.example.kotlintp.auth

import com.example.kotlintp.common.ApiResponse
import com.example.kotlintp.article.RetrofitTools.Companion.retrofit
import com.example.kotlintp.article.Article
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

data class LoginRequest(var email: String, var password : String){

}

interface AuthService {

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest) : ApiResponse<String>

    object AuthApi {
        val authService : AuthService by lazy { retrofit.create(AuthService::class.java) }
    }
}

