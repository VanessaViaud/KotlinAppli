package com.example.kotlintp.article

import androidx.lifecycle.ViewModel
import com.example.kotlintp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticleViewModel : ViewModel() {

    private val _emojis = MutableStateFlow(
        listOf(
            Article("GLASSES", "emoji with glasses", R.drawable.glasses),
            Article("LOVE", "emoji with hearts for eyes", R.drawable.love),
            Article("LAUGH", "emoji with big laugh", R.drawable.laugh),
            Article("SLEEP", "emoji who's sleeping", R.drawable.sleeping),
            Article("THINK", "emoji who's thinking", R.drawable.thinking),
        )
    )
    val emojis: StateFlow<List<Article>> = _emojis

    var emojisNew = MutableStateFlow(
        Article("GLASSES COPY", "this is a copy !!!!!!", R.drawable.glasses)
    )

    fun addArticle() {
        _emojis.value = _emojis.value + emojisNew.value
    }
}
