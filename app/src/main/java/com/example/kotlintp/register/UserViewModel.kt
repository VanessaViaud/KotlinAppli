package com.example.kotlintp.register

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintp.R
import com.example.kotlintp.auth.LoginActivity
import com.example.kotlintp.common.AppAlertHelpers
import com.example.kotlintp.common.AppContextHelper
import com.example.kotlintp.common.AppProgressHelper
import com.example.kotlintp.common.commonCallApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

data class UserViewModel(
    var email: String,
    var password: String,
    var passwordConfirm: String,
    var pseudo: String,
    var cityCode: String,
    var city: String,
    var phone: String
) : ViewModel() {



    fun callSignUpApi(context: Context) {

        val loadingMessage = context.getString(R.string.text_register_loading_message)

        commonCallApi<User>(loadingMessage, coroutineScope = viewModelScope, doAction = {
            val apiResponse = UserService.UserApi.userService.register(
                UserRequest(
                    email,
                    password,
                    passwordConfirm,
                    pseudo,
                    cityCode,
                    city,
                    phone
                )
            )
            if (apiResponse.code.equals("200")) {
                   AppContextHelper.openActivity(context, LoginActivity::class)
               }
                apiResponse
            })
        }}
