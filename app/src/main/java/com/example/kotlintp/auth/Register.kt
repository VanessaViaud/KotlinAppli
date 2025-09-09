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

class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterPage()
        }
    }
}

@Composable
fun RegisterPage() {
    TemplatePage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .padding(top = 10.dp)

        ) {
            var pseudo by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var rememberPassword by remember { mutableStateOf("") }
            var cityCode by remember { mutableStateOf("") }
            var city by remember { mutableStateOf("") }
            var phoneNumber by remember { mutableStateOf("") }
            Icon(
                painter = painterResource(R.drawable.bloc_note),
                contentDescription = "",
                modifier = Modifier.size(60.dp),
                tint = Color.White,
            )
            Text(
                "Welcome to the registration page",
                color = textColor, fontStyle = FontStyle.Italic,
                fontSize = 14.sp,
                modifier = Modifier.padding(10.dp)
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ), onValueChange = { pseudo = it }, value = "", placeholder = {
                    Text("Pseudo", color = textColorButton)
                })
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ), onValueChange = { email = it }, value = "", placeholder = {
                    Text("Email", color = textColorButton)
                })
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ), onValueChange = { password = it }, value = "", placeholder = {
                    Text("Password", color = textColorButton)
                })
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ), onValueChange = { rememberPassword = it }, value = "", placeholder = {
                    Text("Password Confirmation", color = textColorButton)
                })
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ), onValueChange = { cityCode = it }, value = "", placeholder = {
                    Text("City Code", color = textColorButton)
                })
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ), onValueChange = { city = it }, value = "", placeholder = {
                    Text("City", color = textColorButton)
                })
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ), onValueChange = { phoneNumber = it }, value = "", placeholder = {
                    Text("Phone Number", color = textColorButton)
                })
            InputButton(
                onClick = {},
                "SIGN IN"
            )
            Text(
                "By resgistering, i accept the Terms ohf Service and Privacy Policy",
                color = textColor, fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    KotlinTpTheme {
        RegisterPage()
    }
}