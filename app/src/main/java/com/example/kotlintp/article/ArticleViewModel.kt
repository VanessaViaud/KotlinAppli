package com.example.kotlintp.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {

    val articles = MutableStateFlow<List<Article>>(
        mutableListOf())

    fun callArticlesApi() {
        viewModelScope.launch {
            articles.value = ArticleService.ArticleServiceApi.articleService.getArticles()
        }
    }
}
