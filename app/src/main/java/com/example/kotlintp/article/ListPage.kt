package com.example.kotlintp.article

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.kotlintp.R
import com.example.kotlintp.common.AppContextHelper
import com.example.kotlintp.ui.theme.CardContainer
import com.example.kotlintp.ui.theme.InputButton
import com.example.kotlintp.ui.theme.KotlinTpTheme
import com.example.kotlintp.ui.theme.TemplatePage
import com.example.kotlintp.ui.theme.TextDesign
import com.example.kotlintp.ui.theme.WrapPadding
import com.example.kotlintp.ui.theme.cardTextColor

class ListPage : ComponentActivity() {

    lateinit var viewModel: ArticleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val viewModel = ArticleViewModel()
            ListArticlesPage(viewModel)
        }
    }
}

@Composable
fun ListArticlesPage(viewModel: ArticleViewModel) {
    val context =LocalContext.current
    TemplatePage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            TextDesign(stringResource(R.string.article_title))

            ArticleListView(viewModel)

            InputButton(
                onClick = {
                    viewModel.callArticlesApi(context)
                },
                textButton = stringResource(R.string.btn_load)
            )
            InputButton(
                onClick = {
                    AppContextHelper.openActivity(context, ArticleEditPage::class)
                },
                textButton = stringResource(R.string.btn_manage)
            )

        }

    }
}

@Composable
fun ArticleListView(viewModel: ArticleViewModel) {
    val context = LocalContext.current
    val articlesState by viewModel.articles.collectAsState()

    LazyColumn {
        items(articlesState) { article ->
            WrapPadding {
                CardContainer {
                    Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        AsyncImage(
                            model = article.imgPath,
                            contentDescription = article.desc,
                            modifier = Modifier
                                .padding(5.dp)
                                .size(100.dp)
                                .padding(10.dp),
                            placeholder = painterResource(R.drawable.thinking),

                            )
                        Column(modifier = Modifier.widthIn(min = 40.dp, max = 210.dp),
                            horizontalAlignment = Alignment.Start) {
                            Text(
                                article.title,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontSize = 24.sp,
                                color = cardTextColor,
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    shadow = Shadow(
                                        color = Color.Black, blurRadius = 7f
                                    )
                                )
                            )
                            Text(
                                article.author,
                                color = cardTextColor,
                            )
                            Text(
                                article.desc,
                                color = cardTextColor,
                            )
                        }
                        Column {

                            Icon(
                                painter = painterResource(R.drawable.details),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable(onClick = {
                                        val intent = Intent(context, ArticlePage::class.java)
                                        intent.putExtra("article_id", article.id)
                                        context.startActivity(intent)
                                    }),
                                tint = Color.White,
                            )
                            Spacer(modifier = Modifier.size(20.dp))
                            Icon(
                                painter = painterResource(R.drawable.poubelle),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable(onClick = {
                                        viewModel.deleteArticleApi(article.id, context)
                                    }),
                                tint = Color.White,
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun APreview() {
    KotlinTpTheme {
        ListArticlesPage(ArticleViewModel())
    }
}