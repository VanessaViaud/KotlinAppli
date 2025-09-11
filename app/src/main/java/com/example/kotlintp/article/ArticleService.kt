package com.example.kotlintp.article

import com.example.kotlintp.article.RetrofitTools.Companion.retrofit
import retrofit2.http.GET

interface ArticleService {

    @GET("android-articles.json")
    suspend fun getArticles(): List<Article>

    object ArticleServiceApi {

        val articleService: ArticleService by lazy {

            retrofit.create(ArticleService::class.java)
        }
    }
}