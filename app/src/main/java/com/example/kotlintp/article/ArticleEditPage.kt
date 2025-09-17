package com.example.kotlintp.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kotlintp.R
import com.example.kotlintp.ui.theme.InputButton
import com.example.kotlintp.ui.theme.KotlinTpTheme
import com.example.kotlintp.ui.theme.TemplatePage
import com.example.kotlintp.ui.theme.TextDesign
import com.example.kotlintp.ui.theme.TextFieldDesign
import kotlinx.coroutines.flow.MutableStateFlow

class ArticleEditPage : ComponentActivity() {

    lateinit var viewModel: ArticleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val articleId = intent.getStringExtra("article_id")

        viewModel = ArticleViewModel()

        enableEdgeToEdge()
        setContent {
            ArticleEditPage(viewModel)
        }
    }

}

@Composable
fun ArticleEditPage(viewModel: ArticleViewModel) {

    TemplatePage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            TextDesign("Create or update an article")

            ArticleEditView(viewModel)
        }
    }
}


@Composable
fun ArticleEditView(viewModel: ArticleViewModel) {

    val context = LocalContext.current
    val viewModelState by viewModel.article.collectAsState()

    Box {

            Column {
                viewModelState?.id?.let {
                    TextFieldDesign(
                        label = "id",
                        value = it,
                        onValueChange = { value ->
                            viewModel.article.value = viewModel.article.value?.copy(id = value)
                        }
                    )
                }
                viewModelState?.title?.let {
                    TextFieldDesign(
                        label = "title",
                        value = it,
                        onValueChange = { value ->
                            viewModel.article.value = viewModel.article.value?.copy(title = value)
                        }
                    )
                }
                viewModelState?.author?.let {
                    TextFieldDesign(
                        label = "author",
                        value = it,
                        onValueChange = { value ->
                            viewModel.article.value = viewModel.article.value?.copy(author = value)
                        }
                    )
                }
                viewModelState?.desc?.let {
                    TextFieldDesign(
                        label = "description",
                        value = it,
                        onValueChange = { value ->
                            viewModel.article.value = viewModel.article.value?.copy(desc = value)
                        }
                    )
                }
                viewModelState?.imgPath?.let {
                    TextFieldDesign(
                        label = "image link",
                        value = it,
                        onValueChange = { value ->
                            viewModel.article.value = viewModel.article.value?.copy(imgPath = value)
                        }
                    )
                }
                Spacer(modifier = Modifier.size(20.dp))
                viewModelState?.let {
                    InputButton(
                        onClick = {
                            viewModel.saveArticleApi(context)
                        },
                        "SAVE"
                    )
                }
            }

    }
}


@Preview(showBackground = true)
@Composable
fun ArticleEditPreview() {
    KotlinTpTheme {
        ListArticlesPage(ArticleViewModel())
    }
}