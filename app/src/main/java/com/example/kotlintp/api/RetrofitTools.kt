package com.example.kotlintp.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitTools {

    companion object{

       // val BASE_URL = "http://10.0.2.2:3000/"
// à remplacer par (si utilisation de mon tèl) :
val BASE_URL = "http://localhost:3000/"
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build();

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL).build();
    }
}