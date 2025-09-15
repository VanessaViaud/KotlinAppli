package com.example.kotlintp.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintp.R
import com.example.kotlintp.common.AppContextHelper
import com.example.kotlintp.forgottenPassword.ForgottenPassword
import com.example.kotlintp.register.Register
import com.example.kotlintp.ui.theme.IconDesign
import com.example.kotlintp.ui.theme.InputButton
import com.example.kotlintp.ui.theme.KotlinTpTheme
import com.example.kotlintp.ui.theme.TemplatePage
import com.example.kotlintp.ui.theme.TextDesign
import com.example.kotlintp.ui.theme.TextFieldDesign
import com.example.kotlintp.ui.theme.textColor
import kotlinx.coroutines.flow.MutableStateFlow

class LoginActivity : ComponentActivity() {

    lateinit var viewModel : MutableStateFlow<AuthViewModel>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewModel = MutableStateFlow(AuthViewModel(email = "isaac@gmail.com", password = "password"))

        setContent {
            MainPage(viewModel)
        }
    }
}


@Composable
fun MainPage(viewModel: MutableStateFlow<AuthViewModel>) {
    val context = LocalContext.current

    val viewModelState by viewModel.collectAsState()

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

            TextFieldDesign(
                label = "Email",
                value = viewModelState.email,
                onValueChange = { value -> viewModel.value = viewModel.value.copy(email = value)},
            )


            TextFieldDesign(
                label = "Password",
                value = viewModelState.password,
                onValueChange = { value -> viewModel.value = viewModel.value.copy(password = value)}
            )

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
                        AppContextHelper.openActivity(context, ForgottenPassword::class)
                    }
            )
            InputButton(
                onClick = {
                    viewModelState.callLoginApi(context)
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
                        AppContextHelper.openActivity(context, Register::class)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinTpTheme {
        val viewModel = MutableStateFlow(AuthViewModel(email = "isaac@gmail.com", password = "password"))

        MainPage(viewModel)
    }
}