package com.example.kotlintp.register

import com.example.kotlintp.api.ApiResponse
import com.example.kotlintp.api.RetrofitTools.Companion.retrofit

import retrofit2.http.Body
import retrofit2.http.POST

data class UserRequest (var email: String, var password: String, var passwordConfirm: String, var pseudo: String, var cityCode: String, var city: String, var phone: String)
//on pourrait aussi faire une open data class de User pour pour pouvoir en hériter
// et repartir de User pour faire notre ViewModel comme ceci:
//open class User(var email: String = "user@example.com", var password : String = "password", var pseudo: String = "User", var cityCode: String = "44000", var city : String = "Nantes", var phone : String = "0600000000"){}
//data class SignUpRequest(var passwordConfirm : String = "password") : User() {}

interface UserService {

    @POST("signup")
    suspend fun register(@Body userRequest: UserRequest) : ApiResponse<User>

    object UserApi {
        val userService : UserService by lazy { retrofit.create(UserService::class.java) }
    }
}

