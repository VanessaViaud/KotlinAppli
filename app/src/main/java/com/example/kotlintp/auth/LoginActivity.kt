package com.example.kotlintp.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintp.R
import com.example.kotlintp.ui.theme.InputButton
import com.example.kotlintp.ui.theme.KotlinTpTheme
import com.example.kotlintp.ui.theme.TemplatePage
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
    TemplatePage {
        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .padding(top = 50.dp)
        ) {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            Icon(
                painter = painterResource(R.drawable.user_icon),
                contentDescription = "",
                modifier = Modifier.size(100.dp),
                tint = Color.White,
            )
            Text(
                "Please be aware when you enter credentials in the login page",
                color = textColor, fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                modifier = Modifier.padding(10.dp)
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ), onValueChange = { email = it }, value = "", placeholder = {
                    Text("Email", color = textColorButton)
                })
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                onValueChange = { password = it }, value = "", placeholder = {
                    Text("Password", color = textColorButton)
                })
            Text(
                "Forgot your password ??",
                color = textColor, fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                modifier = Modifier.padding(10.dp)
            )
            InputButton(
                onClick = {},
                "CONNEXION"
            )
            Text(
                "Don't have an account ?",
                color = textColor, fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                "Register now",
                color = textColor, fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                modifier = Modifier.padding(10.dp)
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