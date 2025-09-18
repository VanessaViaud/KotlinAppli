package com.example.kotlintp.resetPassword

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintp.R
import com.example.kotlintp.auth.LoginActivity
import com.example.kotlintp.common.AppAlertHelpers
import com.example.kotlintp.common.AppContextHelper
import com.example.kotlintp.common.commonCallApi
import kotlinx.coroutines.launch

data class ResetPasswordViewModel(
    var email: String
) : ViewModel() {


    fun callResetPasswordApi(context: Context) {

        val loadingMessage = context.getString(R.string.text_reset_password_loading_message)
        commonCallApi(loadingMessage, coroutineScope = viewModelScope, doAction = {
            val resetPasswordRequest =
                ResetPasswordRequest(email)
            val apiResponse = ResetPasswordService.ResetPasswordApi.resetPasswordService.resetPassword(resetPasswordRequest)
            if (apiResponse.code.equals("200")) {
                AppContextHelper.openActivity(context, LoginActivity::class)
            }
            apiResponse
        })


    }


}
