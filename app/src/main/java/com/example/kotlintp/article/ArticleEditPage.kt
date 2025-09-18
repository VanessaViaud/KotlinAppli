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
import androidx.compose.ui.res.stringResource
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
            TextDesign(stringResource(R.string.text_article_title))

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
                        label = stringResource(R.string.field_id_hint),
                        value = it,
                        onValueChange = { value ->
                            viewModel.article.value = viewModel.article.value?.copy(id = value)
                        }
                    )
                }
                viewModelState?.title?.let {
                    TextFieldDesign(
                        label = stringResource(R.string.field_title_hint),
                        value = it,
                        onValueChange = { value ->
                            viewModel.article.value = viewModel.article.value?.copy(title = value)
                        }
                    )
                }
                viewModelState?.author?.let {
                    TextFieldDesign(
                        label = stringResource(R.string.field_author_hint),
                        value = it,
                        onValueChange = { value ->
                            viewModel.article.value = viewModel.article.value?.copy(author = value)
                        }
                    )
                }
                viewModelState?.desc?.let {
                    TextFieldDesign(
                        label = stringResource(R.string.field_description_hint),
                        value = it,
                        onValueChange = { value ->
                            viewModel.article.value = viewModel.article.value?.copy(desc = value)
                        }
                    )
                }
                viewModelState?.imgPath?.let {
                    TextFieldDesign(
                        label = stringResource(R.string.field_img_path_hint),
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
                        stringResource(R.string.btn_save)
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