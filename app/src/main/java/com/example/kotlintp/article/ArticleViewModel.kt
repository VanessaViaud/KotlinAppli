package com.example.kotlintp.article

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintp.R
import com.example.kotlintp.common.AppContextHelper
import com.example.kotlintp.common.commonCallApi
import kotlinx.coroutines.flow.MutableStateFlow

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

    fun callArticlesApi(context: Context) {
        //à modifier car il n'est pas idéal d'appeler le context dans le viewModel
        val loadingMessage = context.getString(R.string.text_articles_loading_message)
        commonCallApi<List<Article>>(loadingMessage, viewModelScope, doAction = {
            val apiResponse = ArticleService.ArticleServiceApi.articleService.getResponseJson()
            articles.value = apiResponse.data!!
            apiResponse // c'est un return implicite
        })
    }

    fun callOneArticleApi(articleId: String, context: Context) {
        val loadingMessage = context.getString(R.string.text_article_loading_message)
        commonCallApi<Article>(loadingMessage, viewModelScope, doAction = {
            val apiResponse =
                ArticleService.ArticleServiceApi.articleService.getResponseJsonArticle(articleId)
            article.value = apiResponse.data
            apiResponse
        })
    }

    fun deleteArticleApi(articleId: String, context: Context) {
        val loadingMessage = context.getString(R.string.text_delete_loading_message)

        commonCallApi<Boolean>(loadingMessage, viewModelScope, doAction = {
            val apiResponse =
                ArticleService.ArticleServiceApi.articleService.deleteArticle(articleId)
            if (apiResponse.code.equals("200")) {
                AppContextHelper.openActivity(context, ListPage::class)
            }
            apiResponse
        })
    }


    fun saveArticleApi(context: Context) {
        val loadingMessage = context.getString(R.string.text_article_saving_message)

        commonCallApi<Article>(loadingMessage, viewModelScope, doAction = {
            val apiResponse =
                ArticleService.ArticleServiceApi.articleService.setResponseJsonArticle(
                    ArticleRequest(
                        id = article.value!!.id,
                        title = article.value!!.title,
                        desc = article.value!!.desc,
                        author = article.value!!.author,
                        imgPath = article.value!!.imgPath
                    )
                )
            if (apiResponse.code.equals("200")) {
                AppContextHelper.openActivity(context, ListPage::class)
            }
            apiResponse
        })
    }
}