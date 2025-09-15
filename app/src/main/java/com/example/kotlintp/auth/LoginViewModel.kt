package com.example.kotlintp.auth

import android.content.Context
import androidx.compose.ui.platform.LocalGraphicsContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintp.article.ListPage
import com.example.kotlintp.common.AppProgressHelper

import com.example.kotlintp.common.AppAlertHelpers
import com.example.kotlintp.common.AppContextHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

data class AuthViewModel(var email: String, var password: String) : ViewModel() {


    fun callLoginApi(context: Context){

        // Affiche un ecran de chargement avant un appel async
        AppProgressHelper.get().show("Tentative de connexion")

        viewModelScope.launch {

            // Fake wait 1 sec
            delay(duration = 1.seconds)

            // DTO pour request body a partir des valeurs saisies
            val loginRequest = LoginRequest(email, password)

            val apiResponse = AuthService.AuthApi.authService.login(loginRequest)

            // Fermer ecran de chargement à la fin de l'appel async
            AppProgressHelper.get().close()

            // Stocker le token
            if (apiResponse.code.equals("200")){
                AuthContext.get().setAuthToken(apiResponse.data!!);
            }

            // Afficher le message du back
            AppAlertHelpers.get().show(apiResponse.message, onClose = {
                // Si Code success alors ouvrir la page list article
                if (apiResponse.code.equals("200")){
                    AppContextHelper.openActivity(context, ListPage::class)
                }
            })
        }

    }


}
