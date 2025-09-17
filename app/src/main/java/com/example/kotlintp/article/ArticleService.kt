package com.example.kotlintp.article

import com.example.kotlintp.article.RetrofitTools.Companion.retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

data class ArticleRequest(
    var id: String,
    var title: String,
    var desc: String,
    var author: String,
    var imgPath: String)
interface ArticleService {

    @GET("articles")
    suspend fun getResponseJson(): ResponseJson

    @GET("articles/{id}")
    suspend fun getResponseJsonArticle(@Path ("id") articleId: String): ResponseJsonSingle

    @POST("articles/save")
    suspend fun setResponseJsonArticle(@Body articleRequest: ArticleRequest): ResponseJsonSingle

    @DELETE("articles/{id}")
    suspend fun deleteArticle(@Path ("id") articleId: String): ResponseJsonDelete

    object ArticleServiceApi {

        val articleService: ArticleService by lazy {

            retrofit.create(ArticleService::class.java)
        }
    }

    companion object
}

