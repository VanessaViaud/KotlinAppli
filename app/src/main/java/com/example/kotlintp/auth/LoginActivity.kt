package com.example.kotlintp.auth

import android.content.Intent
import android.os.Bundle
import android.text.util.Linkify
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintp.article.ListPage
import com.example.kotlintp.R
import com.example.kotlintp.common.AppContexteHelper
import com.example.kotlintp.ui.theme.IconDesign
import com.example.kotlintp.ui.theme.InputButton
import com.example.kotlintp.ui.theme.KotlinTpTheme
import com.example.kotlintp.ui.theme.TemplatePage
import com.example.kotlintp.ui.theme.TextDesign
import com.example.kotlintp.ui.theme.TextFieldDesign
import com.example.kotlintp.ui.theme.textColor
import com.example.kotlintp.ui.theme.textColorButton

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainPage()
        }
    }
}

@Composable
fun MainPage() {
    val context = LocalContext.current
    TemplatePage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .padding(top = 50.dp)

        ) {
            IconDesign(R.drawable.user_icon, 100)
            TextDesign(
                "Please be aware when you enter credentials in the login page"
            )
            TextFieldDesign("Email")
            TextFieldDesign("Password")

            Text(
                text = "Forgot your password ??",
                color = textColor,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
                    .clickable {
                        AppContexteHelper.openActivity(context, ForgottenPassword::class)
                    }
            )
            InputButton(
                onClick = {
                    AppContexteHelper.openActivity(context, ListPage::class)
                },
                "CONNEXION"
            )
            TextDesign("Don't have an account ?")

            Text(
                text = "Register now",
                color = textColor,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clickable {
                        AppContexteHelper.openActivity(context, Register::class)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinTpTheme {
        MainPage()
    }
}