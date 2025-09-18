package com.example.kotlintp.common

import android.content.Context
import android.content.Intent
import kotlin.reflect.KClass

class AppContextHelper {

    //pour faire une fonction static en kotlin car ça existe pas à proprement parlé
    companion object {

        /**
         * activityClass: Typage en parametre (ex: MainActivity::class.java)
         */
        fun openActivity(context: Context, activityClass: KClass<*>){
            val intent = Intent(context, activityClass.java)
            context.startActivity(intent)
        }
    }
}

