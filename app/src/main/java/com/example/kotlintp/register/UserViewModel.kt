package com.example.kotlintp.register

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintp.auth.LoginActivity
import com.example.kotlintp.common.AppAlertHelpers
import com.example.kotlintp.common.AppContextHelper
import com.example.kotlintp.common.AppProgressHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

data class UserViewModel(var email: String, var password: String, var passwordConfirm: String, var pseudo: String, var cityCode: String, var city: String, var phone: String) : ViewModel() {


    fun callSignUpApi(context: Context){

        AppProgressHelper.get().show("Création de compte en cours")
        viewModelScope.launch {


            delay(duration = 2.seconds)

            val userRequest = UserRequest(email, password, passwordConfirm, pseudo, cityCode, city, phone)

            val apiResponse = UserService.UserApi.userService.register(userRequest)


            AppProgressHelper.get().close()

           AppAlertHelpers.get().show(apiResponse.message, onClose = {


                if (apiResponse.code.equals("200")){
                    AppContextHelper.openActivity(context, LoginActivity::class)
                }
            })
        }

    }


}
