package com.example.kotlintp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlintp.ui.theme.KotlinTpTheme
import com.example.kotlintp.ui.theme.TemplatePage

class List : ComponentActivity() {
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
    TemplatePage {

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text("List of articles")
        LazyColumn {
            var persons: MutableList<String> = mutableListOf(
                "Isaac",
                "Gregory"
            )
            items(persons) { person ->
                Text(text = person)
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



