package com.example.kotlintp.resetPassword

import com.example.kotlintp.common.ApiResponse
import com.example.kotlintp.article.RetrofitTools.Companion.retrofit

import retrofit2.http.Body
import retrofit2.http.POST

data class ResetPasswordRequest (var email: String)
//on pourrait aussi faire une open data class de User pour pour pouvoir en hériter
// et repartir de User pour faire notre ViewModel comme ceci:
//open class User(var email: String = "user@example.com", var password : String = "password", var pseudo: String = "User", var cityCode: String = "44000", var city : String = "Nantes", var phone : String = "0600000000"){}
//data class SignUpRequest(var passwordConfirm : String = "password") : User() {}

interface ResetPasswordService {

    @POST("reset-password")
    suspend fun resetPassword(@Body email: ResetPasswordRequest) : ApiResponse<String>

    object ResetPasswordApi {
        val resetPasswordService : ResetPasswordService by lazy { retrofit.create(ResetPasswordService::class.java) }
    }
}

