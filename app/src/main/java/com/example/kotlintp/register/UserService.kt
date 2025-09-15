package com.example.kotlintp.register

import com.example.kotlintp.common.ApiResponse
import com.example.kotlintp.article.RetrofitTools.Companion.retrofit

import retrofit2.http.Body
import retrofit2.http.POST

data class UserRequest (var email: String, var password: String, var passwordConfirm: String, var pseudo: String, var cityCode: String, var city: String, var phone: String)
interface UserService {

    @POST("signup")
    suspend fun register(@Body userRequest: UserRequest) : ApiResponse<User>

    object UserApi {
        val userService : UserService by lazy { retrofit.create(UserService::class.java) }
    }
}

