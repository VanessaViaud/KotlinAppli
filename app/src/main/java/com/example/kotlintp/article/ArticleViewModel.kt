package com.example.kotlintp.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintp.auth.LoginActivity
import com.example.kotlintp.common.AppAlertHelpers
import com.example.kotlintp.common.AppContextHelper
import com.example.kotlintp.common.AppProgressHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import kotlin.time.Duration.Companion.seconds
import android.content.Context

data class NewArticleViewModel(
    var id: String,
    var title: String,
    var desc: String,
    var author: String,
    var imgPath: String
) : ViewModel() {

}

class ArticleViewModel : ViewModel() {

    val articles = MutableStateFlow<List<Article>>(
        mutableListOf()
    )
    val article = MutableStateFlow<Article?>(
        Article(id = "", title = "", author = "", desc = "", imgPath = "")
    )
    fun callArticlesApi() {

        //ici afficher un écran de chargement
        AppProgressHelper.get().show("Chargement en cours")

        viewModelScope.launch {
            articles.value = ArticleService.ArticleServiceApi.articleService.getResponseJson().data!!

// ici fermer l'écran de chargement
            AppProgressHelper.get().close()

        }
    }

    fun callOneArticleApi(articleId: String) {
        viewModelScope.launch {
            article.value =
                ArticleService.ArticleServiceApi.articleService.getResponseJsonArticle(articleId).data
        }
    }

    fun deleteArticleApi(articleId: String, context: Context) {
        viewModelScope.launch {
            val apiResponse =
                ArticleService.ArticleServiceApi.articleService.deleteArticle(articleId)

            AppAlertHelpers.get().show(apiResponse.message, onClose = {
                if (apiResponse.code.equals("200")) {
                    AppContextHelper.openActivity(context, ListPage::class)
                }
            })
        }
    }

    fun saveArticleApi(context: Context) {
        viewModelScope.launch {
            val articleRequest =
                ArticleRequest(
                    id = article.value!!.id,
                    title = article.value!!.title,
                    desc = article.value!!.desc,
                    author = article.value!!.author,
                    imgPath = article.value!!.imgPath
                )

            val apiResponse =
                ArticleService.ArticleServiceApi.articleService.setResponseJsonArticle(
                    articleRequest
                )

            AppAlertHelpers.get().show(apiResponse.message, onClose = {

                if (apiResponse.code.equals("200")) {
                    AppContextHelper.openActivity(context, ListPage::class)
                }
            })
        }
    }

}