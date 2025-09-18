package com.example.kotlintp.common

import android.content.Context
import android.content.Intent
import com.example.kotlintp.api.ApiResponse
import com.example.kotlintp.common.AppContextHelper.Companion.debugLoading
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import kotlin.reflect.KClass
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

class AppContextHelper {

    //pour faire une fonction static en kotlin car ça existe pas à proprement parlé
    companion object {

        val debugLoading : Duration = 1.milliseconds
        /**
         * activityClass: Typage en parametre (ex: MainActivity::class.java)
         */
        fun openActivity(context: Context, activityClass: KClass<*>){
            val intent = Intent(context, activityClass.java)
            context.startActivity(intent)
        }
    }
}

fun <T> commonCallApi(loadingMsg : String = "Chargement", coroutineScope : CoroutineScope, doAction: suspend () -> ApiResponse<T>){

    // Affiche un ecran de chargement avant un appel async
    AppProgressHelper.get().show(loadingMsg)

    coroutineScope.launch {

        // Fake wait 2 sec
        delay(duration = debugLoading)

        val apiResponse = doAction()

        // Fermer ecran de chargement à la fin de l'appel async
        AppProgressHelper.get().close()

        // Afficher le message du back
        AppAlertHelpers.get().show(apiResponse.message)
    }
}