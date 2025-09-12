package com.example.kotlintp.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintp.common.AppProgressHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import kotlin.time.Duration.Companion.seconds

class ArticleViewModel : ViewModel() {

    val articles = MutableStateFlow<List<Article>>(
        mutableListOf()
    )
    val article = MutableStateFlow<Article?>(null)

    fun callArticlesApi() {

        //ici afficher un écran de chargement
        AppProgressHelper.get().show("Chargement en cours")

        viewModelScope.launch {
            articles.value = ArticleService.ArticleServiceApi.articleService.getResponseJson().data

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

}
