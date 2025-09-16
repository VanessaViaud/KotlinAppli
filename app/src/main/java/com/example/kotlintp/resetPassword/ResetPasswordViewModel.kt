package com.example.kotlintp.resetPassword

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintp.auth.LoginActivity
import com.example.kotlintp.common.AppAlertHelpers
import com.example.kotlintp.common.AppContextHelper
import kotlinx.coroutines.launch

data class ResetPasswordViewModel(
    var email: String
) : ViewModel() {


    fun callResetPasswordApi(context: Context) {

        viewModelScope.launch {

            val resetPasswordRequest =
                ResetPasswordRequest(email)

            val apiResponse = ResetPasswordService.ResetPasswordApi.resetPasswordService.resetPassword(resetPasswordRequest)

            val messageAlert = "${apiResponse.message}. Votre nouveau mot de passe est ${apiResponse.data}."

            AppAlertHelpers.get().show(messageAlert, onClose = {

                if (apiResponse.code.equals("200")) {
                    AppContextHelper.openActivity(context, LoginActivity::class)
                }

            })
        }

    }


}
