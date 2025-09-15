package com.example.kotlintp.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlintp.R
import com.example.kotlintp.common.AppContextHelper
import com.example.kotlintp.ui.theme.IconDesign
import com.example.kotlintp.ui.theme.InputButton
import com.example.kotlintp.ui.theme.KotlinTpTheme
import com.example.kotlintp.ui.theme.TemplatePage
import com.example.kotlintp.ui.theme.TextDesign
import com.example.kotlintp.ui.theme.TextFieldDesign

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
    val context = LocalContext.current
    var pseudo by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmation by remember { mutableStateOf("") }
    var cityCode by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    TemplatePage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)

        ) {
            IconDesign(R.drawable.bloc_note, 50)
            TextDesign("Welcome to the registration page")
            TextFieldDesign("Pseudo", value = pseudo,
                onValueChange = { pseudo = it })
            TextFieldDesign("Email", value = email,
                onValueChange = { email = it })
            TextFieldDesign("Password", value = password,
                onValueChange = { password = it })
            TextFieldDesign("Password Confirmation", value = confirmation,
                onValueChange = { confirmation = it })
            TextFieldDesign("City Code", value = cityCode,
                onValueChange = { cityCode = it })
            TextFieldDesign("City", value = city,
                onValueChange = { city = it })
            TextFieldDesign("Phone Number", value = phoneNumber,
                onValueChange = { phoneNumber = it })
            Spacer(modifier = Modifier.size(20.dp))
            InputButton(
                onClick = {AppContextHelper.openActivity(context, LoginActivity::class)},
                "SIGN IN"
            )
            TextDesign("By registering, i accept the Terms ohf Service and Privacy Policy")
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