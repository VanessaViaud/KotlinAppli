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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlintp.R
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
    TemplatePage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)

        ) {
            IconDesign(R.drawable.bloc_note, 50)
            TextDesign("Welcome to the registration page")
            TextFieldDesign("Pseudo")
            TextFieldDesign("Email")
            TextFieldDesign("Password")
            TextFieldDesign("Password Confirmation")
            TextFieldDesign("City Code")
            TextFieldDesign("City")
            TextFieldDesign("Phone Number")
            Spacer(modifier = Modifier.size(20.dp))
            InputButton(
                onClick = {},
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