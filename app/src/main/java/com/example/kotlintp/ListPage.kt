package com.example.kotlintp

import android.R.attr.offset
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintp.ui.theme.CardContainer
import com.example.kotlintp.ui.theme.KotlinTpTheme
import com.example.kotlintp.ui.theme.TemplatePage
import com.example.kotlintp.ui.theme.TextDesign
import com.example.kotlintp.ui.theme.WrapPadding
import com.example.kotlintp.ui.theme.cardImageColor
import com.example.kotlintp.ui.theme.cardTextColor

class ListPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListArticlesPage()
        }
    }
}

@Composable
fun ListArticlesPage() {
    var emojis: MutableList<Article> = mutableListOf(
        Article("GLASSES", "emoji with glasses", R.drawable.glasses),
        Article("LOVE", "emoji with hearts for eyes", R.drawable.love),
        Article("LAUGH", "emoji with big laugh", R.drawable.laugh),
        Article("SLEEP", "emoji who's sleeping", R.drawable.sleeping),
        Article("THINK", "emoji who's thinking", R.drawable.thinking),

        )
    TemplatePage {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)

        ) {
            TextDesign("List of contouring emojis")
            LazyColumn {
                items(emojis) { emoji ->
                    WrapPadding {
                        CardContainer {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(emoji.imgPath),
                                    contentDescription = (emoji.desc),
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .size(100.dp)
                                        .padding(10.dp),
                                    tint = cardImageColor,
                                )
                                Column () {
                                    Text(
                                        emoji.title,
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
                                        emoji.desc,
                                        color = cardTextColor,
                                    )
                                }
                            }


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
        ListArticlesPage()
    }
}



