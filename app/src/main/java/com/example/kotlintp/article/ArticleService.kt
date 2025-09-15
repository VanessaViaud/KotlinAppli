package com.example.kotlintp.article

import com.example.kotlintp.article.RetrofitTools.Companion.retrofit
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticleService {

    @GET("articles")
    suspend fun getResponseJson(): ResponseJson

    @GET("articles/{id}")
    suspend fun getResponseJsonArticle(@Path ("id") articleId: String): ResponseJsonSingle

    @POST("save-article")
    suspend fun setResponseJsonArticle(articleId: String): ResponseJson

    @DELETE("article/{id}")
    fun deleteArticle(articleId: String)

    object ArticleServiceApi {

        val articleService: ArticleService by lazy {

            retrofit.create(ArticleService::class.java)
        }
    }

    companion object
}

