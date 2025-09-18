package com.example.kotlintp.resetPassword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintp.R
import com.example.kotlintp.ui.theme.InputButton
import com.example.kotlintp.ui.theme.KotlinTpTheme
import com.example.kotlintp.ui.theme.TemplatePage
import com.example.kotlintp.ui.theme.TextDesign
import com.example.kotlintp.ui.theme.TextFieldDesign
import com.example.kotlintp.ui.theme.textColorButton
import kotlinx.coroutines.flow.MutableStateFlow


class ForgottenPassword : ComponentActivity() {

    lateinit var viewModel: MutableStateFlow<ResetPasswordViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel = MutableStateFlow(
            ResetPasswordViewModel(
                email = "vv@vv.com"
            )
        )
        setContent {
            PasswordPage(viewModel)
        }
    }
}

@Composable
fun PasswordPage(viewModel: MutableStateFlow<ResetPasswordViewModel>) {
    val context = LocalContext.current

    val viewModelState by viewModel.collectAsState()

    TemplatePage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .padding(top = 200.dp)
        ) {

            Text(
                stringResource(R.string.reset_password_title),
                color = textColorButton,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )
            TextFieldDesign(
                "Email", value = viewModelState.email,
                onValueChange = { value -> viewModel.value.copy(email = value) })
            InputButton(
                onClick = {
                    viewModelState.callResetPasswordApi(context)
                },
                stringResource(R.string.btn_reset_password)
            )
            TextDesign(stringResource(R.string.text_reset_password_advice))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GPreview() {
    KotlinTpTheme {
        val viewModel = MutableStateFlow(ResetPasswordViewModel(email = "vv@vv.com"))
        PasswordPage(viewModel)
    }
}